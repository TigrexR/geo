package com.tigrex.geo.elasticsearch.repository;

import com.tigrex.geo.elasticsearch.entity.UserEl;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<UserEl, Long> {
}
