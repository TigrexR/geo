package com.tigrex.geo.entity.bo;

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
public class UserBO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private Integer age;
}
