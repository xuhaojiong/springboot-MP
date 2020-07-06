package ciih.dsg.xhj.controller;


import ciih.dsg.xhj.entity.FieldData;
import ciih.dsg.xhj.entity.Table;
import ciih.dsg.xhj.entity.TableData;
import ciih.dsg.xhj.entity.TableField;
import ciih.dsg.xhj.service.ITableDataService;
import ciih.dsg.xhj.service.ITableFieldService;
import ciih.dsg.xhj.service.ITableService;
import ciih.dsg.xhj.util.LocalDateTimeUtils;
import ciih.dsg.xhj.util.ServiceResult;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xhj
 * @since 2020-05-15
 */
@RestController
@RequestMapping("/table")
@Api(tags = "自定义表单")
public class TableController {
    private final List<Object> emptyList = new ArrayList<>();

    @Autowired
    private ITableService tableService;
    @Autowired
    private ITableFieldService tableFieldService;
    @Autowired
    private ITableDataService tableDataService;

    @ApiOperation(value = "新增或修改表单")
    @PostMapping("/createTable")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", dataType = "int", required = false, paramType = "query"),
            @ApiImplicitParam(name = "tableName", value = "表名", dataType = "string", required = true, paramType = "query"),
            @ApiImplicitParam(name = "description", value = "描述", dataType = "string", required = false, paramType = "query")
    })
    public ServiceResult createTable(HttpServletRequest request, Integer id, String tableName, String description) {
        if (tableName.isEmpty()) {
            return ServiceResult.failure(emptyList, "表名不能为空", request);
        }

        Table table = new Table();
        if (id == null) {
            table.setTableName(tableName);
            table.setDescription(description);
            tableService.save(table);
        } else {
            table = tableService.getById(id);
            table.setTableName(tableName);
            table.setDescription(description);
            tableService.updateById(table);
        }

        return ServiceResult.success(emptyList, "操作成功", request);
    }

    @ApiOperation(value = "新增或修改表单字段")
    @PostMapping("/createTableFieled")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", dataType = "int", required = false, paramType = "query"),
            @ApiImplicitParam(name = "tableName", value = "表名", dataType = "string", required = true, paramType = "query"),
            @ApiImplicitParam(name = "description", value = "描述", dataType = "string", required = false, paramType = "query")
    })
    public ServiceResult createTableFieled(HttpServletRequest request, Integer tableId, String fieldName, String fieldDescription, String fieldType,
                                           Integer fieldLength, Integer isNotNull, Integer isPrimaryKey, String defaultValue) {
        Table table = tableService.getById(tableId);

        TableField tableField = new TableField();
        tableField.setTableId(tableId);
        tableField.setTableName(table.getTableName());
        tableField.setFieldName(fieldName);
        tableField.setFieldDescription(fieldDescription);
        tableField.setFieldType(fieldType);
        tableField.setFieldLength(fieldLength);
        tableField.setIsNotNull(isNotNull);
        tableField.setIsPrimaryKey(isPrimaryKey);
        tableField.setDefaultValue(defaultValue);
        tableFieldService.save(tableField);

        return ServiceResult.success(emptyList, "操作成功", request);
    }

    @ApiOperation(value = "新增或修改表单数据")
    @PostMapping("/createTableData")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", dataType = "int", required = false, paramType = "query"),
            @ApiImplicitParam(name = "tableName", value = "表名", dataType = "string", required = true, paramType = "query"),
            @ApiImplicitParam(name = "description", value = "描述", dataType = "string", required = false, paramType = "query")
    })
    public ServiceResult createTableData(HttpServletRequest request, Integer tableId, String fieldDataList) {
        QueryWrapper<TableField> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TableField::getTableId, tableId);
        List<TableField> fieldList = tableFieldService.list(wrapper);

        List<FieldData> dataList = JSONObject.parseArray(fieldDataList, FieldData.class);

        for (TableField tableField : fieldList) {
            if (tableField.getIsNotNull() == 1) {
                int i = 0;
                for (FieldData fieldData : dataList) {
                    if (fieldData.getField().equals(tableField.getId())) {
                        i = 1;
                        break;
                    }
                }
                if (i == 0) {
                    return ServiceResult.failure(emptyList, "字段" + tableField.getFieldDescription() + "不能为空", request);
                }
            }
            if (tableField.getIsPrimaryKey() == 1) {
                QueryWrapper<TableData> wrapper1 = new QueryWrapper<>();
                wrapper1.lambda().eq(TableData::getFieldId, tableField.getId());
                List<TableData> dataList1 = tableDataService.list(wrapper1);
                for (FieldData fieldData : dataList) {
                    if (fieldData.getField().equals(tableField.getId())) {
                        for (TableData tableData : dataList1) {
                            switch (tableField.getFieldType()) {
                                case "string":
                                    if (tableData.getStringData().equals(fieldData.getFieldData().toString())) {
                                        return ServiceResult.failure(emptyList, "主键" + tableField.getFieldDescription() + "不能重复", request);
                                    }
                                    break;
                                case "int":
                                    if (tableData.getIntData().equals(Integer.parseInt(fieldData.getFieldData().toString()))) {
                                        return ServiceResult.failure(emptyList, "主键" + tableField.getFieldDescription() + "不能重复", request);
                                    }
                                    break;
                                case "date":
                                    if (tableData.getDateData().isEqual(LocalDateTimeUtils.string2LocalDate(fieldData.getFieldData().toString()))) {
                                        return ServiceResult.failure(emptyList, "主键" + tableField.getFieldDescription() + "不能重复", request);
                                    }
                                    break;
                                case "datetime":
                                    if (tableData.getDatetimeData().isEqual(LocalDateTimeUtils.string2LocalDateTime(fieldData.getFieldData().toString()))) {
                                        return ServiceResult.failure(emptyList, "主键" + tableField.getFieldDescription() + "不能重复", request);
                                    }
                                    break;
                                case "longtext":
                                    if (tableData.getLongtextData().equals(fieldData.getFieldData().toString())) {
                                        return ServiceResult.failure(emptyList, "主键" + tableField.getFieldDescription() + "不能重复", request);
                                    }
                                    break;
                                default:
                                    break;
                            }

                        }
                    }
                }
            }
        }

        int rowId = 0;
        QueryWrapper<TableData> wrapper1 = new QueryWrapper<>();
        wrapper1.lambda().eq(TableData::getTableId, tableId);
        List<TableData> tableDataList = tableDataService.list(wrapper1);
        if (tableDataList.size() == 0) {
            rowId = 1;
        } else {
            tableDataList.sort(new Comparator<TableData>() {
                @Override
                public int compare(TableData o1, TableData o2) {
                    // 按照rowId降序排列
                    if (o1.getRowId() < o2.getRowId()) {
                        return 1;
                    }
                    if (o1.getRowId().equals(o2.getRowId())) {
                        return 0;
                    }
                    return -1;
                }
            });
            rowId = tableDataList.get(0).getRowId() + 1;
        }

        List<TableData> tableDataList1 = new ArrayList<>();
        for (TableField tableField : fieldList) {
            TableData tableData = new TableData();
            tableData.setTableId(tableId);
            tableData.setRowId(rowId);
            tableData.setFieldId(tableField.getId());
            for (FieldData fieldData : dataList) {
                if (fieldData.getField().equals(tableField.getId())) {
                    switch (tableField.getFieldType()) {
                        case "string":
                            tableData.setStringData(fieldData.getFieldData().toString());
                            break;
                        case "int":
                            tableData.setIntData(Integer.parseInt(fieldData.getFieldData().toString()));
                            break;
                        case "date":
                            tableData.setDateData(LocalDateTimeUtils.string2LocalDate(fieldData.getFieldData().toString()));
                            break;
                        case "datetime":
                            tableData.setDatetimeData(LocalDateTimeUtils.string2LocalDateTime(fieldData.getFieldData().toString()));
                            break;
                        case "longtext":
                            tableData.setLongtextData(fieldData.getFieldData().toString());
                            break;
                        default:
                            break;
                    }
                }
            }

            tableDataList1.add(tableData);
        }

        tableDataService.saveBatch(tableDataList1);

        return ServiceResult.success(emptyList, "操作成功", request);
    }

    @ApiOperation(value = "新增或修改表单数据")
    @PostMapping("/getAllTable")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", dataType = "int", required = false, paramType = "query"),
            @ApiImplicitParam(name = "tableName", value = "表名", dataType = "string", required = true, paramType = "query"),
            @ApiImplicitParam(name = "description", value = "描述", dataType = "string", required = false, paramType = "query")
    })
    public ServiceResult getAllTable(HttpServletRequest request, Integer pageNo, Integer pageSize) {
        IPage<Table> iPage = new Page<>(pageNo, pageSize);
        IPage<Table> page = tableService.page(iPage);
        return ServiceResult.success(page, "获取成功", request);
    }

    @ApiOperation(value = "新增或修改表单数据")
    @PostMapping("/getTableField")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", dataType = "int", required = false, paramType = "query"),
            @ApiImplicitParam(name = "tableName", value = "表名", dataType = "string", required = true, paramType = "query"),
            @ApiImplicitParam(name = "description", value = "描述", dataType = "string", required = false, paramType = "query")
    })
    public ServiceResult getTableField(HttpServletRequest request, Integer tableId) {
        QueryWrapper<TableField> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TableField::getTableId, tableId);
        List<TableField> fieldList = tableFieldService.list(wrapper);

        return ServiceResult.success(fieldList, "获取成功", request);
    }

    @ApiOperation(value = "新增或修改表单数据")
    @PostMapping("/getTableData")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", dataType = "int", required = false, paramType = "query"),
            @ApiImplicitParam(name = "tableName", value = "表名", dataType = "string", required = true, paramType = "query"),
            @ApiImplicitParam(name = "description", value = "描述", dataType = "string", required = false, paramType = "query")
    })
    public ServiceResult getTableData(HttpServletRequest request, Integer tableId){
//        QueryWrapper<TableField> wrapper = new QueryWrapper<>();
//        wrapper.lambda().eq(TableField::getTableId, tableId);
//        List<TableField> fieldList = tableFieldService.list(wrapper);

        QueryWrapper<TableData> wrapper1 = new QueryWrapper<>();
        wrapper1.lambda().eq(TableData::getTableId, tableId);
        List<TableData> dataList = tableDataService.list(wrapper1);

        for (TableData tableData : dataList) {
            QueryWrapper<TableField> wrapper = new QueryWrapper<>();
            wrapper.lambda().eq(TableField::getTableId, tableData.getFieldId());
            List<TableField> fieldList = tableFieldService.list(wrapper);
            for (TableField tableField : fieldList) {
                tableField.setFieldType(tableField.getFieldDescription());
                tableField.setFieldName(super.toString());
                tableField.setDefaultValue("");
                tableField.setIsNotNull(0);
                tableField.setFieldDescription("");
                if (tableField.equals(tableField)){
                    String stringData = tableData.getStringData();
                    boolean b = stringData.startsWith("");
                    if (b) {
                        return ServiceResult.success(emptyList, "", request);
                    }

                }


            }
        }
        return null;
    }
}
