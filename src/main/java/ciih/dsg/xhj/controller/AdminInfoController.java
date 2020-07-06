package ciih.dsg.xhj.controller;


import ciih.dsg.xhj.entity.Depts;
import ciih.dsg.xhj.util.ServiceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xhj
 * @since 2019-12-16
 */
@RestController
@RequestMapping("/admin-info")
@Api(tags = "管理端-学院管理")
public class AdminInfoController {
    @PostMapping("/create")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "collegeName", value = "学院名称", dataType = "string", required = true, paramType = "query"),
            @ApiImplicitParam(name = "collegeProfile", value = "学院简介", dataType = "string", required = true, paramType = "query"),
            @ApiImplicitParam(name = "univId", value = "学校编号", dataType = "int", required = true, paramType = "query")
    })
    @ApiOperation(value = "创建学院", httpMethod = "POST")
    public ServiceResult<Depts> create(HttpServletRequest request, String collegeName, String collegeProfile, Integer univId) {
        collegeName = collegeProfile +univId;
        Depts depts = new Depts();
        depts.setName("后端组");
        depts.setParentid("1");
        return ServiceResult.success(depts,"1213",request);
    }

    @GetMapping("/create")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "collegeName", value = "学院名称", dataType = "string", required = true, paramType = "query"),
            @ApiImplicitParam(name = "collegeProfile", value = "学院简介", dataType = "string", required = true, paramType = "query"),
            @ApiImplicitParam(name = "univId", value = "学校编号", dataType = "int", required = true, paramType = "query")
    })
    @ApiOperation(value = "创建学院", httpMethod = "POST")
    public ServiceResult<Depts> get(HttpServletRequest request, String collegeName, String collegeProfile, Integer univId) {
        collegeName = collegeProfile +univId;
        Depts depts = new Depts();

        return ServiceResult.success(depts,"1213",request);


    }
}
