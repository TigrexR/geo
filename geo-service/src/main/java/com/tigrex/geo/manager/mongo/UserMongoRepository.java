package com.tigrex.geo.manager.mongo;

import com.tigrex.geo.entity.mongo.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author linus
 */
@Repository(value = "userMongoRepository")
public interface UserMongoRepository extends MongoRepository<UserMongo, Integer> {
}
