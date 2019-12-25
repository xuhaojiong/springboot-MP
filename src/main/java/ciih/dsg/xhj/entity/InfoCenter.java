package ciih.dsg.xhj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
 * @since 2019-12-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="InfoCenter对象", description="")
public class InfoCenter implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "info_id", type = IdType.AUTO)
    private Integer infoId;

    private String infoTitle;

    private String infoContent;

    @ApiModelProperty(value = "时间")
    private LocalDateTime infoTime;

    @ApiModelProperty(value = "办学单位")
    private String collegeName;

    @ApiModelProperty(value = "1校历2学生手册3校史校情4校规5安全教育")
    private Integer infoType;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer collegeId;


}
