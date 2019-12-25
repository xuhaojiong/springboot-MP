package ciih.dsg.xhj.service;

import ciih.dsg.xhj.entity.AdminInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xhj
 * @since 2019-12-16
 */
public interface IAdminInfoService extends IService<AdminInfo> {
    int deleteAll();
}
