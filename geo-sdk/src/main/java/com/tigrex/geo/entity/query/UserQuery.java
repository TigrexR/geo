package com.tigrex.geo.entity.query;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author linus
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserQuery implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String name;

    private Integer age;
}
