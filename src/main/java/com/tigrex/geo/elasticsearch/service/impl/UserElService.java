package com.tigrex.geo.elasticsearch.service.impl;

import com.tigrex.geo.elasticsearch.entity.UserEl;
import com.tigrex.geo.elasticsearch.repository.UserRepository;
import com.tigrex.geo.elasticsearch.service.IUserElService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserElService implements IUserElService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean save(UserEl user) {
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean exist(UserEl user) {
        return userRepository.existsById(user.getId().longValue());
    }

}
