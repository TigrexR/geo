package com.tigrex.geo.manager.es;

import com.tigrex.geo.entity.es.UserElasticsearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author linus
 */
@Repository(value = "userElasticsearchRepository")
public interface UserElasticsearchRepository extends ElasticsearchRepository<UserElasticsearch, Integer> {
}
