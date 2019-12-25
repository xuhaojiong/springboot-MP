package ciih.dsg.xhj;

import ciih.dsg.xhj.entity.ClassInfo;
import ciih.dsg.xhj.entity.es.EsBlog;
import ciih.dsg.xhj.repository.EsBlogRepository;
import ciih.dsg.xhj.service.IClassInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Iterator;

@SpringBootTest
class XhjApplicationTests {
    @Autowired
    EsBlogRepository blogRepository;
    @Autowired
    private IClassInfoService iClassInfoService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testEs(){
        ClassInfo classInfo = new ClassInfo();
        classInfo.setClassName("sdada");
        classInfo.setCreateTime(LocalDateTime.now());
        iClassInfoService.save(classInfo);
    }
}
