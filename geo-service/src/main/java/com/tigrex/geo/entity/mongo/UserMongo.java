package com.tigrex.geo.entity.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.io.Serializable;

/**
 * @author linus
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "user")
public class UserMongo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    @Field(value = "code", targetType = FieldType.STRING)
    private String code;
    @Field(value = "name", targetType = FieldType.STRING)
    private String name;
    @Field(value = "age", targetType = FieldType.INT32)
    private Integer age;
    @Field(value = "gender", targetType = FieldType.STRING)
    private String gender;
}
