package ciih.dsg.xhj;

import ciih.dsg.xhj.entity.es.EsBlog;
import ciih.dsg.xhj.repository.EsBlogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;

@SpringBootTest
class XhjApplicationTests {
    @Autowired
    EsBlogRepository blogRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testEs(){
        Iterable<EsBlog> all = blogRepository.findAll();
        Iterator<EsBlog> iterator = all.iterator();
        EsBlog next = iterator.next();
        System.out.println(next);
    }
}
