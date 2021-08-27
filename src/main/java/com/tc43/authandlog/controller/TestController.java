package com.tc43.authandlog.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    /**
     * Controller层只负责处理路由，将请求发送给service层，异常由service层抛出到controller层，再由controller返回给客户端错误信息
     */
}
