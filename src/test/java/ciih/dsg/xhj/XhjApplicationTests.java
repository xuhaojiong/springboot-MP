package ciih.dsg.xhj;

import ciih.dsg.xhj.entity.es.EsBlog;
import ciih.dsg.xhj.repository.EsBlogRepository;
import ciih.dsg.xhj.util.LargeExcelFileReadUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootTest
class XhjApplicationTests {
    @Autowired
    EsBlogRepository blogRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testEs() {
        Iterable<EsBlog> all = blogRepository.findAll();
        Iterator<EsBlog> iterator = all.iterator();
        EsBlog next = iterator.next();
        System.out.println(next);
    }

    @Test
    public void testPoi() throws Exception {
        Long time = System.currentTimeMillis();
        LargeExcelFileReadUtil example = new LargeExcelFileReadUtil();

        example.processOneSheet("C:/Users/xuhj/Desktop/student.xlsx");
        Long endtime = System.currentTimeMillis();
        LinkedHashMap<String, String> map = example.getRowContents();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        int count = 0;
        String prePos = "";
        while (it.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
            String pos = entry.getKey();
            if (!pos.substring(1).equals(prePos)) {
                prePos = pos.substring(1);
                count++;
            }
            System.out.println(pos + ";" + entry.getValue());
        }
        System.out.println("解析数据" + count + "条;耗时" + (endtime - time) + "秒");
    }
}
