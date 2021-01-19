package com.nchu.countryside.controller;

import com.nchu.countryside.domain.entity.JsonResult;
import com.nchu.countryside.domain.entity.User;
import com.nchu.countryside.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @program: countryside
 * @author: Xing guo ning
 * @description：
 * @Date: 2021-01-18 17:36
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUser/{id}")
    @ApiOperation(value = "根据用户唯一标识获取用户信息")
    public JsonResult<User> getUserInfo(@PathVariable @ApiParam(value = "用户唯一 标识") Long id) {
            User user = userService.findUserById(id);
            return new JsonResult().ok(user);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "添加用户信息")
    public JsonResult<Void> insertUser(@RequestBody @ApiParam(value = "用户信息") User user) {
        // 处理添加逻辑
        System.out.println(user.toString());
        return new JsonResult<>().ok();
    }
}
