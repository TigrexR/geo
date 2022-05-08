package com.tigrex.geo.api;

import com.tigrex.geo.entity.dto.UserDTO;
import com.tigrex.geo.entity.query.UserQuery;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author linus
 */
@FeignClient(value = "geo", contextId = "userClient", path = "/user")
public interface UserClient {

    /**
     * hello
     * @return string
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
	String hello();

    /**
     * get user
     * @param userQuery
     * @return user
     */
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    UserDTO getUser(@RequestBody() UserQuery userQuery);
}
