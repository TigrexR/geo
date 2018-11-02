package com.tigrex.geo.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tigrex.geo.entity.User;
import com.tigrex.geo.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<BaseMapper<User>, User> implements IUserService {

}
