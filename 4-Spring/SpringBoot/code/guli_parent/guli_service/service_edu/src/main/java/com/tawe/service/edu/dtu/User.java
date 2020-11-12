package com.tawe.service.edu.dtu;

import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @Author davidt
 * @Date 11/10/2020 2:40 PM
 * @Version 1.0
 **/

@Data
public class User {
    private String name;
    private String[] roles;
    private String avatar;
    private String introduction;
}