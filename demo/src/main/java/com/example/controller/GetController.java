package com.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @program: SpringBootDemo
 * @description: get方法接口
 * @description: 在该类中展示了swagger的用法，直接访问localhost:8888/swagger-ui.html
 */

@RestController
@Api(value="/",description = "GetMethod类接口文档")
public class GetController {

  /**
   * 定义get请求接口，返回cookie信息
   * ApiOperation注解定义了swagger接口文档中展示的说明信息
   */
  @ApiOperation(value = "定义get请求接口，返回cookie信息",httpMethod = "Get")
  @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
  public String getCookies(HttpServletResponse response) {
    Cookie cookie = new Cookie("phone_number","15012345671");
    response.addCookie(cookie);
    return "定义get请求接口，返回cookie信息";
  }

  /**
   * 定义get请求接口，要求携带cookie信息
   * cookie在请求头header中，因此需要定义HttpServletRequest参数
   */
  @ApiOperation(value = "定义get请求接口，要求携带cookie信息",httpMethod = "Get")
  @RequestMapping(value = "/getWithCookies",method = RequestMethod.GET)
  public String getWithCookies(HttpServletRequest request) {
    Cookie[] cookies = request.getCookies();
    if(Objects.isNull(cookies)) {
      return "请携带cookie信息";
    }
    for(Cookie cookie:cookies) {
      if(cookie.getName().equals("phone_number") &&
              cookie.getValue().equals("15012345671")) {
        return "get请求携带了正确的cookie信息，返回结果";
      }
    }
    return "cookie信息错误！";
  }

  /**
   * 定义get请求接口，要求携带参数，第一种写接口的方式
   * 请求方式格式： localhost:8888/getWithParam?username=May&password=123456
   * @Request 注释后面跟随的参数名，应和get请求中的参数名一致
   */
  @ApiOperation(value = "定义get请求接口，要求携带参数，第一种写接口方式",httpMethod = "Get")
  @RequestMapping(value = "/getWithParam1",method = RequestMethod.GET)
  public Map<String,String> getWithParam_1(@RequestParam String username,
                                           @RequestParam String password) {
    Map<String,String> list = new HashMap<>();
    list.put("username_1",username);
    list.put("password_1",password);

    return list;
  }

  /**
   * 定义get请求接口，要求携带参数，第二种写接口的方式
   * 请求方式格式： localhost:8888/getWithParam/May/123456
   * @Request 注释后面跟随的参数名，应和get请求中的参数名一致
   */
  @ApiOperation(value = "定义get请求接口，要求携带参数，第二种写接口方式",httpMethod = "Get")
  @RequestMapping(value = "/getWithParam2/{username}/{password}",method = RequestMethod.GET)
  public Map<String,String> getWithParam_2(@PathVariable String username,@PathVariable String password) {
    Map<String,String> list = new HashMap<>();
    list.put("username_1",username);
    list.put("password_1",password);

    return list;
  }
}
