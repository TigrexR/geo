package com.tigrex.geo.controller;

import com.tigrex.geo.entity.bo.UserBO;
import com.tigrex.geo.entity.query.UserQuery;
import com.tigrex.geo.entity.vo.UserVO;
import com.tigrex.geo.service.IUserService;
import com.tigrex.geo.utils.JacksonUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RefreshScope
public class UserController {

    @Value("${isGeo:false}")
    private boolean isGeo;
    @Autowired
    private IUserService userService;
    @Autowired
    private RedisTemplate<String, UserBO> userRedisTemplate;

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String hello() {
        return "hello world! I'm " + isGeo;
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public UserVO getUser(@RequestBody() UserQuery userQuery) {
        return JacksonUtils.getJackson().convertValue(userService.getUser(userQuery), UserVO.class);
    }

    @RequestMapping(value = "/getUserFromRedis", method = RequestMethod.POST)
    public UserVO getUserFromRedis(@RequestBody() UserQuery userQuery) {
        return JacksonUtils.getJackson().convertValue(userRedisTemplate.opsForValue().get("users::" + userQuery.getId()),
                UserVO.class);
    }

    @RequestMapping(value = "/sendUser2Kafka", method = RequestMethod.POST)
    public Integer sendUser2Kafka(@RequestBody() UserQuery userQuery) {
        return userService.sendUser2Kafka(userService.getUser(userQuery));
    }

    @RequestMapping(value = "/saveUser2Mongo", method = RequestMethod.POST)
    public UserVO saveUser2Mongo(@RequestBody() UserQuery userQuery) {
        return JacksonUtils.getJackson().convertValue(userService.saveUser2Mongo(userService.getUser(userQuery)), UserVO.class);
    }

    @RequestMapping(value = "/saveUser2Es", method = RequestMethod.POST)
    public UserVO saveUser2Es(@RequestBody() UserQuery userQuery) {
        return JacksonUtils.getJackson().convertValue(userService.saveUser2Es(userService.getUser(userQuery)), UserVO.class);
    }
}
