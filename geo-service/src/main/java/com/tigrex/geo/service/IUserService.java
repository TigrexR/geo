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
    public UserBO getUser(UserQuery userQuery);
}