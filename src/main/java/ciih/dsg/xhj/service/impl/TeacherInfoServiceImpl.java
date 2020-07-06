package ciih.dsg.xhj.service.impl;

import ciih.dsg.xhj.entity.TeacherInfo;
import ciih.dsg.xhj.mapper.TeacherInfoMapper;
import ciih.dsg.xhj.service.ITeacherInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 教师表 服务实现类
 * </p>
 *
 * @author xuhj
 * @since 2020-07-06
 */
@Service
public class TeacherInfoServiceImpl extends ServiceImpl<TeacherInfoMapper, TeacherInfo> implements ITeacherInfoService {

    @Override
    public  IPage<TeacherInfo> findListByPage(Integer page, Integer pageCount){
        IPage<TeacherInfo> wherePage = new Page<>(page, pageCount);
        TeacherInfo where = new TeacherInfo();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(TeacherInfo teacherInfo){
        return baseMapper.insert(teacherInfo);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(TeacherInfo teacherInfo){
        return baseMapper.updateById(teacherInfo);
    }

    @Override
    public TeacherInfo findById(Long id){
        return  baseMapper.selectById(id);
    }
}
