package com.example.mybookstore2.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = -5758112239328827L;
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String sex;
    private String perm;
    private String role;

}
