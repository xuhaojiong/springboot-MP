package ciih.dsg.xhj.repository;

import ciih.dsg.xhj.entity.es.EsBlog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsBlogRepository extends ElasticsearchRepository<EsBlog,Integer> {
}
