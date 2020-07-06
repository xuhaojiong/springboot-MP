package ciih.dsg.xhj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xhj
 * @since 2020-03-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Student对象", description="")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "学生姓名")
    private String stuName;

    @ApiModelProperty(value = "性别（1男2女）")
    private Integer sex;

    @ApiModelProperty(value = "学号")
    private String stuCode;

    @ApiModelProperty(value = "学生身份证")
    private String stuCardNo;

    @ApiModelProperty(value = "联系电话")
    private String phone;

    @ApiModelProperty(value = "家庭地址")
    private String address;

    @ApiModelProperty(value = "家庭联系方式")
    private String familyPhone;

    @ApiModelProperty(value = "班级id")
    private Integer classId;

    @ApiModelProperty(value = "班级名称")
    private String className;

    @ApiModelProperty(value = "宿舍id")
    private Integer dormitoryId;

    @ApiModelProperty(value = "学院id")
    private Integer collegeId;

    @ApiModelProperty(value = "学院名称")
    private String collegeName;

    @ApiModelProperty(value = "专业id")
    private Integer majorId;

    @ApiModelProperty(value = "专业名称")
    private String majorName;

    private String ybUserId;


}
