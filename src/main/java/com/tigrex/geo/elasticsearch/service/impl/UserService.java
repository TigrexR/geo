package com.tigrex.geo.elasticsearch.service.impl;

import com.tigrex.geo.elasticsearch.entity.User;
import com.tigrex.geo.elasticsearch.repository.UserRepository;
import com.tigrex.geo.elasticsearch.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean save(User user) {
        userRepository.save(user);
        return true;
    }

}
