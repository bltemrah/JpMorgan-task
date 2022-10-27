package com.jpMorgan.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(allowSetters = true)

public class NumberOfPost {

    private Object userId;
    private Object id;
    private Object title;
    private Object body;

}
