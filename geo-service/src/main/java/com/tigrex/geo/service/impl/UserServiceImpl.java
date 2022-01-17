package com.tigrex.geo.service.impl;

import com.tigrex.geo.entity.bo.UserBO;
import com.tigrex.geo.entity.query.UserQuery;
import com.tigrex.geo.mapper.UserMapper;
import com.tigrex.geo.service.IUserService;
import com.tigrex.geo.utils.JacksonUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author linus
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public UserBO getUser(UserQuery userQuery) {
        return JacksonUtils.getJackson().convertValue(mapper.selectById(userQuery.getName()), UserBO.class);
    }

}
