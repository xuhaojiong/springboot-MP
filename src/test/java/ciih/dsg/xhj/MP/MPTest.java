package ciih.dsg.xhj.MP;

import ciih.dsg.xhj.mapper.AdminInfoMapper;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MPTest {
    @Autowired
    private AdminInfoMapper adminInfoMapper;

    @Test
    public void insert(){
//        AdminInfo adminInfo = new AdminInfo();
//        adminInfo.setAdminCode("xhj");
//        adminInfo.setAdminPass("111111");
//        adminInfo.setAdminName("许浩迥");
//        adminInfoMapper.insert(adminInfo);

        int rows = adminInfoMapper.deleteAll();
        System.out.println(rows);
    }
}
