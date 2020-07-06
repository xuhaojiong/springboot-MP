package ciih.dsg.xhj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
 * @since 2020-05-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TableData对象", description="")
public class TableData implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "表id")
    private Integer tableId;

    @ApiModelProperty(value = "行id")
    private Integer rowId;

    @ApiModelProperty(value = "字段id")
    private Integer fieldId;

    @ApiModelProperty(value = "string字段值")
    private String stringData;

    @ApiModelProperty(value = "int字段值")
    private Integer intData;

    @ApiModelProperty(value = "date字段值")
    private LocalDate dateData;

    @ApiModelProperty(value = "datetime字段值")
    private LocalDateTime datetimeData;

    @ApiModelProperty(value = "longtext_data")
    private String longtextData;


}
