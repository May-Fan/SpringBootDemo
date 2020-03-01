package com.example.controller;

import com.example.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SpringBootDemo
 * @description:
 * @author: May
 * @create: 2020-02-03 15:22
 */
@RestController
@Api(value = "v1")
@RequestMapping("/v1")
public class UserController {
  @Autowired
  private SqlSessionTemplate template;

  @GetMapping("/getUserCount")
  public Integer getUserCount() {
    return template.selectOne("getUserCount");
  }

  @PostMapping("/addUser")
  public String addUser(@RequestBody User user) {
    template.insert("addUser",user);
    return "新增成功！";
  }
  @GetMapping("/addUsers")
  public @ResponseBody Object addUsers() {
    List<String> array = new ArrayList<>();
    array.add("mary");
    array.add("tom");
    array.add("tommy");
    array.add("caalina");
    return array;
  }

}
