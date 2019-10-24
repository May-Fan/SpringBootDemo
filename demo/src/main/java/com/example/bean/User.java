package com.example.bean;

import lombok.Data;

/**
 * @program: SpringBootDemo
 * @description: 定义User类，在获取post请求时用于获取参数RequestBody
 * @author: May
 * @create: 2019-10-22 16:13
 */
@Data
public class User {
  private Integer id;
  private String name;
  private String sex;
  private Integer age;
  private String phone;
  private double height;


}
