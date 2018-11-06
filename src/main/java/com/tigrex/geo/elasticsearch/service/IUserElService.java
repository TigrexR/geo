package com.tigrex.geo.elasticsearch.service;

import com.tigrex.geo.elasticsearch.entity.UserEl;

public interface IUserElService {

    boolean save(UserEl user);

    boolean exist(UserEl user);

}
