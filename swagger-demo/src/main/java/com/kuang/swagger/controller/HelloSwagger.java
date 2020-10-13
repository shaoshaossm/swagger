package com.kuang.swagger.controller;

import com.kuang.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/10/9 20:00
 */

@RestController
public class HelloSwagger {

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    //只要我们的接口中,返回值存在实体类,他就会扫描到Swagger中
    @PostMapping(value = "/user")
    public User user() {
        return new User();
    }

    @ApiOperation("Hello控制类")
    @GetMapping(value = "/hello2")
    public String hello2(@ApiParam("用户名") String username) {
        return "hello" + username;
    }

    @PostMapping(value = "/postt")
    public User postt(@ApiParam("用户") User user) {
        return user;
    }
}
