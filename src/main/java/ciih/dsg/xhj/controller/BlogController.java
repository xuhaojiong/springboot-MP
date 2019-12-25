package ciih.dsg.xhj.controller;

import ciih.dsg.xhj.entity.es.EsBlog;
import ciih.dsg.xhj.repository.EsBlogRepository;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class BlogController {
    @Autowired
    EsBlogRepository esBlogRepository;

    @PostMapping("/search")
    public void search(){
        StopWatch watch = new StopWatch();
        watch.start();
        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        builder.should(QueryBuilders.matchPhraseQuery("title","牛逼"));
        Page<EsBlog> search = (Page<EsBlog>) esBlogRepository.search(builder);
        List<EsBlog> content = search.getContent();
        watch.stop();
        long totalTimeMillis = watch.getTotalTimeMillis();

        System.out.println(content);
    }
}
