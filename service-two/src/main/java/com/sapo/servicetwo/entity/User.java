package com.sapo.servicetwo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {
    private Integer id;
    private String name;
    private String username;
    private String phone;
    private String password;
    private Date dob;
    private String status;
    private String address;

}
