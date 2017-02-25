package com.lcnet.shane.controller;

import com.lcnet.shane.error.MyException;
import com.lcnet.shane.pojo.User;
import com.lcnet.shane.service.UserService;
import com.lcnet.shane.tools.Result;
import com.lcnet.shane.tools.StringUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xushaoyin on 2017/2/16.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String getUserList() {
        List<User> list = userService.findAll();
        return Result.create(0, "success", list);
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        userService.save(user);
        return Result.create(0, "注册成功", user);
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return userService.findById(id);
    }

    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
//        userService.updateUser(id, user.getUserName(), user.getUserPwd(), user.getUserMobile());
        return "success";
    }

    @ApiOperation(value = "用户登录", notes = "用户根据用户名和密码登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    String login(@PathVariable String userName, @PathVariable String userPwd) {
        if (StringUtil.isEmpty(userName)) {
            return Result.create(1, "用户名不能为空", null);
        }
        if (StringUtil.isEmpty(userPwd)) {
            return Result.create(1, "密码不能为空", null);
        }
        User u = userService.findByUserNameAndUserPwd(userName, userPwd);
        if (u != null) {
            return Result.create(0, "登录成功", null);
        } else {
            return Result.create(1, "登录失败，请重新登录", null);
        }
    }


    @ApiOperation(value = "错误演示", notes = "")
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    String error() throws MyException {
        throw new MyException("hahaha");
    }
}
