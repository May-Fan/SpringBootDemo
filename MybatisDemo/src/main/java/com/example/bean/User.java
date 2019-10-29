package com.example.bean;

import lombok.Data;

/**
 * @program: SpringBootDemo
 * @description: 在新建user接口，传递前端页面传递过来的参数时用到
 * @author: May
 * @create: 2019-10-28 15:13
 */
@Data
public class User {
  private int id;
  private String username;
  private String password;
  private String email;
  private String create_time;
}
