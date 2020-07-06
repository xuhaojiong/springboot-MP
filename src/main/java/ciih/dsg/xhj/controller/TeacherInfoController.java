package ciih.dsg.xhj.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import ciih.dsg.xhj.service.ITeacherInfoService;
import ciih.dsg.xhj.entity.TeacherInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 教师表 前端控制器
 * </p>
 *
 * @author xuhj
 * @since 2020-07-06
 */
@Api(tags = {"教师表"})
@RestController
@RequestMapping("/teacher-info")
public class TeacherInfoController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ITeacherInfoService teacherInfoService;


    @ApiOperation(value = "新增教师表")
    @PostMapping()
    public int add(@RequestBody TeacherInfo teacherInfo){
        return teacherInfoService.add(teacherInfo);
    }

    @ApiOperation(value = "删除教师表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return teacherInfoService.delete(id);
    }

    @ApiOperation(value = "更新教师表")
    @PutMapping()
    public int update(@RequestBody TeacherInfo teacherInfo){
        return teacherInfoService.updateData(teacherInfo);
    }

    @ApiOperation(value = "查询教师表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<TeacherInfo> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return teacherInfoService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询教师表")
    @GetMapping("{id}")
    public TeacherInfo findById(@PathVariable Long id){
        return teacherInfoService.findById(id);
    }

}
