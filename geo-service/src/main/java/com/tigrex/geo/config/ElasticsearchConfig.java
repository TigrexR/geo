package com.tigrex.geo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author linus
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = {"com.tigrex.geo.manager.es"})
public class ElasticsearchConfig {
}
