package com.tigrex.geo.service;

import com.tigrex.geo.entity.bo.UserBO;
import com.tigrex.geo.entity.query.UserQuery;

/**
 * @author linus
 */
public interface IUserService {

    /**
     * get user
     * @param userQuery
     * @return userBO
     */
    UserBO getUser(UserQuery userQuery);

    /**
     * send user
     * @param user user
     * @return int
     */
    Integer sendUser2Kafka(UserBO user);

    /**
     * save uer to mongo
     * @param user user
     * @return int
     */
    UserBO saveUser2Mongo(UserBO user);

    /**
     * save uer to es
     * @param user user
     * @return int
     */
    UserBO saveUser2Es(UserBO user);
}