package ciih.dsg.xhj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生姓名
     */
    private String stuName;

    /**
     * 性别（1男2女）
     */
    private Integer sex;

    /**
     * 学号
     */
    private String stuCode;

    /**
     * 学生身份证
     */
    private String stuCardNo;

    /**
     * 家庭地址
     */
    private String address;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 班级id
     */
    private Integer classId;

    /**
     * 班级名称
     */
    private String className;

    /**
     * 宿舍id
     */
    private Integer dormitoryId;

    /**
     * 学院id
     */
    private Integer collegeId;

    /**
     * 学院名称
     */
    private String collegeName;

    /**
     * 专业id
     */
    private Integer majorId;

    /**
     * 专业名称
     */
    private String majorName;

    private String ybUserId;


}
