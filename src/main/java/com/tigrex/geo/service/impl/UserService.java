package com.tigrex.geo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tigrex.geo.entity.User;
import com.tigrex.geo.service.IUserService;
import org.springframework.stereotype.Component;


@Service(interfaceClass = IUserService.class)
@Component
public class UserService extends ServiceImpl<BaseMapper<User>, User> implements IUserService {

}
