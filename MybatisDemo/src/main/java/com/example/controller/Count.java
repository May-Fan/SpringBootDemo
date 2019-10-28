package com.example.controller;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringBootDemo
 * @description:
 * @author: May
 * @create: 2019-10-25 11:06
 */

@RestController
public class Count {

  @Autowired
  private SqlSessionTemplate template;

  @RequestMapping(value = "/getStudentCount",method = RequestMethod.GET)
  public int getStudentCount() {
    int a = template.selectOne("getStudentCount");
    return a;
  }
}
