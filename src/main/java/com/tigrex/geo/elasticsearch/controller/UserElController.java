package com.tigrex.geo.elasticsearch.controller;

import com.tigrex.geo.elasticsearch.entity.UserEl;
import com.tigrex.geo.elasticsearch.service.IUserElService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/elasticsearch/user")
public class UserElController {

    private static final Logger logger = LoggerFactory.getLogger(UserElController.class);

    @Autowired
    private IUserElService userService;

    @PostMapping(value = "/saveUser")
    public UserEl saveUser(
            HttpServletRequest request,
            HttpServletResponse response,
            UserEl user){
        user.setId(1).setName("george").setAge(13);
        logger.info(user.toString());
        userService.save(user);
        return user;
    }

}
