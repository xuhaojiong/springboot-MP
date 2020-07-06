package ciih.dsg.xhj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 教师表
 * </p>
 *
 * @author xuhj
 * @since 2020-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TeacherInfo对象", description="教师表")
public class TeacherInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "t_id", type = IdType.AUTO)
    private Integer tId;

    @ApiModelProperty(value = "学校代码")
    private String schoolCode;

    @ApiModelProperty(value = "学校名称")
    private String schoolName;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "部门")
    private String unit;

    @ApiModelProperty(value = "职务")
    private String duty;

    @ApiModelProperty(value = "身份证号")
    private String identity;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "办公室电话")
    private String officePhone;

    @ApiModelProperty(value = "家电")
    private String homePhone;

    @ApiModelProperty(value = "性别1男2女")
    private String sex;

    @ApiModelProperty(value = "qq")
    private String qq;

    @ApiModelProperty(value = "邮箱")
    private String mail;

    @ApiModelProperty(value = "排序值")
    private Integer tOrder;

    @ApiModelProperty(value = "办公室排序")
    private String oOrder;

    @ApiModelProperty(value = "添加时间")
    private Date addDate;


}
