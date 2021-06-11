package com.jie.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
public class User {
    private int id;
    private String name;
    private String pwd;


}
