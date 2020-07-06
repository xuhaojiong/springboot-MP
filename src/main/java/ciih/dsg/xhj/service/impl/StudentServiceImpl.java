package ciih.dsg.xhj.service.impl;

import ciih.dsg.xhj.entity.Student;
import ciih.dsg.xhj.mapper.StudentMapper;
import ciih.dsg.xhj.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xhj
 * @since 2020-03-10
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
