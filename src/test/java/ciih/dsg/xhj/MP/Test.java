package ciih.dsg.xhj.MP;

import ciih.dsg.xhj.entity.AdminInfo;
import ciih.dsg.xhj.mapper.AdminInfoMapper;
import ciih.dsg.xhj.service.IAdminInfoService;
import ciih.dsg.xhj.service.IClassInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @Autowired
    private AdminInfoMapper adminInfoMapper;

    @org.junit.jupiter.api.Test
    public void insert(){
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setAdminCode("xhj");
        adminInfo.setAdminPass("111111");
        adminInfo.setAdminName("许浩迥");
        adminInfoMapper.insert(adminInfo);
        adminInfoMapper.selectPage(new Page<>(),new QueryWrapper<>());

//        int rows = adminInfoMapper.deleteAll();
//        System.out.println(rows);
    }
}
