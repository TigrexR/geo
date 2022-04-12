package com.tigrex.geo.controller;

import com.tigrex.geo.entity.bo.UserBO;
import com.tigrex.geo.entity.dto.UserDTO;
import com.tigrex.geo.entity.query.UserQuery;
import com.tigrex.geo.service.IUserService;
import com.tigrex.geo.utils.JacksonUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linus
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private RedisTemplate<String, UserBO> userRedisTemplate;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
        return "hello world!";
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public UserDTO getUser(@RequestBody() UserQuery userQuery) {
        return JacksonUtils.getJackson().convertValue(userService.getUser(userQuery), UserDTO.class);
    }

    @RequestMapping(value = "/getUserFromRedis", method = RequestMethod.POST)
    public UserDTO getUserFromRedis(@RequestBody() UserQuery userQuery) {
        return JacksonUtils.getJackson().convertValue(userRedisTemplate.opsForValue().get("users::" + userQuery.getId()),
                UserDTO.class);
    }
}
