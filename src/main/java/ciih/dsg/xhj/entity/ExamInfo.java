package ciih.dsg.xhj.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
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
public class ExamInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer courseId;

    private String courseName;

    private LocalDateTime examTime;

    private String examRequirement;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 当前年度
     */
    private Integer currentYear;


}
