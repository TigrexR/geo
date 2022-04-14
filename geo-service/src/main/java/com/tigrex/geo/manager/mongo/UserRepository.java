package com.tigrex.geo.manager.mongo;

import com.tigrex.geo.entity.mongo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author linus
 */
@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
}
