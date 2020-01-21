package ciih.dsg.xhj.controller;


import ciih.dsg.xhj.entity.AdminInfo;
import ciih.dsg.xhj.entity.ClassInfo;
import ciih.dsg.xhj.service.IClassInfoService;
import ciih.dsg.xhj.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xhj
 * @since 2019-12-13
 */
@RestController
@RequestMapping("/class-info")
public class ClassInfoController {
    @Autowired
    private IClassInfoService iClassInfoService;

    @PostMapping("/create")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "className", value = "班级名称",dataType="string")
    })
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "Success",response = ClassInfo.class),
//            @ApiResponse(code = 500, message = "服务器内部错误",response = ServiceResult.class)
//    })
    public ServiceResult<IPage<ClassInfo>> create(HttpServletRequest request, String className){
        ClassInfo classInfo = new ClassInfo();
        classInfo.setClassName(className);
        classInfo.setCreateTime(LocalDateTime.now());
        iClassInfoService.save(classInfo);

        IPage<ClassInfo> iPage = new Page<>(1,20);
        IPage<ClassInfo> page = iClassInfoService.page(iPage);
        //classInfo.insert();
        return ServiceResult.success(page,request);
    }

    @PostMapping("/get")
    public ServiceResult<List<ClassInfo>> get(HttpServletRequest request , String className){
        List<ClassInfo> classInfoList = iClassInfoService.list();
        classInfoList.forEach(System.out::println);

        QueryWrapper<ClassInfo> wrapper = new QueryWrapper<>();
        wrapper.lambda().like(ClassInfo::getClassName,className);
        List<ClassInfo> classInfoList1 = iClassInfoService.list(wrapper);
        classInfoList1.forEach(System.out::println);

        return ServiceResult.success(classInfoList,request);
    }
}
