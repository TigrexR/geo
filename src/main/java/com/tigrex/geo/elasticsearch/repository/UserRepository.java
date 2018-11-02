package com.tigrex.geo.elasticsearch.repository;

import com.tigrex.geo.elasticsearch.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<User, Long> {
}
