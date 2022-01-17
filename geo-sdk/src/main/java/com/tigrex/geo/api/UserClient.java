package com.tigrex.geo.api;

import com.tigrex.geo.entity.dto.UserDto;
import com.tigrex.geo.entity.query.UserQuery;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author linus
 */
@FeignClient("UserClient")
public interface UserClient {

    /**
     * hello
     * @return string
     */
    @RequestMapping(value = "/user/hello", method = RequestMethod.GET)
	String hello();

    /**
     * get user
     * @param userQuery
     * @return user
     */
    @RequestMapping(value = "/user/getUser", method = RequestMethod.POST)
	UserDto getUser(@RequestBody() UserQuery userQuery);
}
