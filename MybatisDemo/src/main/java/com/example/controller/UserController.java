package com.example.controller;

import com.example.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: SpringBootDemo
 * @description:
 * @author: May
 * @create: 2019-10-25 11:06
 */

@RestController
public class UserController {

  @Autowired
  private SqlSessionTemplate template;

  /**
   * 查询user表中的用户总数
   * @return 返回用户数量
   */
  @ApiOperation(value = "查询user表中的用户总数",httpMethod = "GET")
  @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
  public int getUserCount() {
    int a = template.selectOne("getUserCount");
    return a;
  }

  /**
   * 增加用户
   */
  @ApiOperation(value = "新增用户",httpMethod = "POST")
  @RequestMapping(value = "addUser",method = RequestMethod.POST)
  public String addUser(@RequestBody User user) {
    template.insert("addUser",user);
    return "新建用户成功！";
  }

  /**
   * 修改用户
   */
  @ApiOperation(value = "修改用户",httpMethod = "POST")
  @RequestMapping(value = "updateUser",method = RequestMethod.POST)
  public String updateUser(@RequestBody User user) {
    template.insert("updateUser",user);
    return "修改用户成功！";
  }

  /**
   * 根据路径中的id删除对应用户
   */
  @ApiOperation(value = "根据路径中的id删除对应用户",httpMethod = "GET")
  @RequestMapping(value = "deleteUser/{id}",method = RequestMethod.GET)
  public String deleteUser(@PathVariable Integer id) {
    template.delete("deleteUser",id);
    return "删除用户成功！";
  }
}
