package ciih.dsg.xhj.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 钉钉中的部门
 * </p>
 *
 * @author zhy
 * @since 2020-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Depts对象", description="钉钉中的部门")
public class Depts implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "钉钉中部门id")
    private String id;

    @ApiModelProperty(value = "钉钉中父级id")
    private String parentid;

    @ApiModelProperty(value = "钉钉中部门名称")
    private String name;

    @ApiModelProperty(value = "初次同步时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "上一次同步时间")
    private Date lastTime;

    @ApiModelProperty(value = "最新同步时间")
    private Date recentTime;


}
