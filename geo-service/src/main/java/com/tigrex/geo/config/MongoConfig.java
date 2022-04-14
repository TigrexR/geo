package com.tigrex.geo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author linus
 */
@Configuration
@EnableMongoRepositories(basePackages = {"com.tigrex.geo.manager.mongo"})
public class MongoConfig {
}
