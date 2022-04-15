package com.tigrex.geo.entity.es;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author linus
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Document(indexName = "user")
public class UserElasticsearch implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    @Field(value = "code", type = FieldType.Text)
    private String code;
    @Field(value = "name", type = FieldType.Text)
    private String name;
    @Field(value = "age", type = FieldType.Integer)
    private Integer age;
    @Field(value = "gender", type = FieldType.Text)
    private String gender;
}
