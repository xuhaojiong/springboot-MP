package ciih.dsg.xhj.mapper;

import ciih.dsg.xhj.entity.AdminInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xhj
 * @since 2019-12-16
 */
public interface AdminInfoMapper extends BaseMapper<AdminInfo> {
    int deleteAll();
}
