package ciih.dsg.xhj.service;

import ciih.dsg.xhj.entity.TeacherInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 教师表 服务类
 * </p>
 *
 * @author xuhj
 * @since 2020-07-06
 */
public interface ITeacherInfoService extends IService<TeacherInfo> {

    /**
     * 查询教师表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<TeacherInfo>
     */
    IPage<TeacherInfo> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加教师表
     *
     * @param teacherInfo 教师表
     * @return int
     */
    int add(TeacherInfo teacherInfo);

    /**
     * 删除教师表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改教师表
     *
     * @param teacherInfo 教师表
     * @return int
     */
    int updateData(TeacherInfo teacherInfo);

    /**
     * id查询数据
     *
     * @param id id
     * @return TeacherInfo
     */
    TeacherInfo findById(Long id);
}
