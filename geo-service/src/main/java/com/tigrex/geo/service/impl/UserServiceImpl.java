package com.tigrex.geo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tigrex.geo.entity.bo.UserBO;
import com.tigrex.geo.entity.dto.UserDTO;
import com.tigrex.geo.entity.es.UserElasticsearch;
import com.tigrex.geo.entity.mongo.UserMongo;
import com.tigrex.geo.entity.query.UserQuery;
import com.tigrex.geo.factory.GeoContext;
import com.tigrex.geo.manager.es.UserElasticsearchRepository;
import com.tigrex.geo.manager.kafka.KafkaSender;
import com.tigrex.geo.manager.mongo.UserMongoRepository;
import com.tigrex.geo.mapper.UserMapper;
import com.tigrex.geo.service.IUserService;
import com.tigrex.geo.task.UserRetryTask;
import com.tigrex.geo.utils.JacksonUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author linus
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper mapper;
    @Autowired
    private KafkaSender<UserDTO> userSender;
    @Autowired
    private UserMongoRepository userRepository;
    @Autowired
    private UserElasticsearchRepository userEsRepository;
    @Autowired
    @Qualifier(value = "geoExecutor")
    private AsyncTaskExecutor executor;

    @Override
    @Cacheable(value = "users", key = "#userQuery.id", cacheManager = "userRedisCacheManager")
    public UserBO getUser(UserQuery userQuery) {
        return JacksonUtils.getJackson().convertValue(mapper.selectById(userQuery.getId()), UserBO.class);
    }

    @Override
    public Integer sendUser2Kafka(UserDTO user) {
        try {
            userSender.send(user, "geo");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public UserBO saveUser2Mongo(UserBO user) {
        return JacksonUtils.getJackson().convertValue(
                userRepository.save(JacksonUtils.getJackson().convertValue(user, UserMongo.class)), UserBO.class);
    }

    @Override
    public UserBO saveUser2Es(UserBO user) {
        return JacksonUtils.getJackson().convertValue(
                userEsRepository.save(JacksonUtils.getJackson().convertValue(user, UserElasticsearch.class)), UserBO.class);
    }

    @Override
    public void executeUser(UserQuery userQuery) {
        executor.execute(GeoContext.getContext().getBean(UserRetryTask.class).setQuery(userQuery));
    }

    @Override
    public void retryUser() {
        System.out.println("hello user");
    }

    @Override
    @Async
    public void asyncUser() {
        System.out.println(Thread.currentThread().getName() + ":hello user");
    }
}
