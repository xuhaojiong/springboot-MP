package ciih.dsg.xhj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
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
 * @since 2019-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="班级", description="")
public class ClassInfo extends Model<ClassInfo> implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "class_id", type = IdType.AUTO)
    @ApiModelProperty(value = "时间")
    private Integer classId;

    /**
     * 班级名称
     */
    @ApiModelProperty(value = "时间")
    private String className;

    /**
     * 班主任
     */
    @ApiModelProperty(value = "时间")
    private Integer teacherId;

    /**
     * 所属专业
     */
    @ApiModelProperty(value = "时间")
    private Integer majorId;

    /**
     * 入学时间
     */
    @ApiModelProperty(value = "时间")
    private LocalDateTime admissionDate;

    /**
     * 所在学院
     */
    @ApiModelProperty(value = "时间")
    private Integer collegeId;

    @ApiModelProperty(value = "时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "时间")

    private LocalDateTime updateTime;


}
