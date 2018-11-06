package com.tigrex.geo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class TestObject implements Serializable {

    private Object base_info;

    private List<BaseInfo> base_list;

    @Data
    @Accessors(chain = true)
    public class BaseInfo implements Serializable{
        private int age;
        private String name;
    }

}
