package com.example.controller;

import com.example.bean.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: SpringBootDemo
 * @description:
 * @author: May
 * @create: 2019-10-22 11:26
 */

@RestController
public class PostController {
  private Cookie cookie;

  /**
   *定义post请求接口，返回cookie信息
   */
  @RequestMapping(value = "/login",method = RequestMethod.POST)
  public String login(HttpServletResponse response,
                      @RequestParam String username,
                      @RequestParam String password) {
    if(username.equals("admin") && password.equals("123456")) {
      cookie = new Cookie(username,password);
      response.addCookie(cookie);
      return "输入正确的用户名密码，返回cookie信息";
    }
    else {
      return "用户名密码错误！";
    }
  }

  /**
   * 定义post接口，要求携带cookie信息
   * cookie信息校验后，再次校验请求参数信息，通过后返回用户信息列表
   */
  @RequestMapping(value = "/getUserMsg",method = RequestMethod.POST)
  public String getUserMsg(HttpServletRequest request,
                           @RequestBody User user) {
    Cookie[] cookies = request.getCookies();
    for(Cookie cookie:cookies) {
      if(cookie.getName().equals("admin") && cookie.getValue().equals("123456")
        && user.getId().equals(27)) {
        user.setId(1);
        user.setName("超级管理员");
        user.setSex("female");
        user.setHeight(1.76);
        user.setPhone("10086");

        return user.toString();
      }
    }
    return "参数错误，请检查参数配置";
  }

}
