package com.tigrex.geo.elasticsearch.controller;

import com.tigrex.geo.elasticsearch.entity.User;
import com.tigrex.geo.elasticsearch.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/elasticsearch/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/saveUser")
    public User saveUser(
            HttpServletRequest request,
            HttpServletResponse response,
            User user){
        user.setId(1).setName("george").setAge(13);
        logger.info(user.toString());
        userService.save(user);
        return user;
    }

}
