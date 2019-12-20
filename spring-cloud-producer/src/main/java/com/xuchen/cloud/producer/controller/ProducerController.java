package com.xuchen.cloud.producer.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;
import com.xuchen.cloud.model.user.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProducerController {

    @Value("${appName}")
    String appName;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        ThreadUtil.sleep(5000);
        log.info("接收到请求：{}", name);
        return StrUtil.format("{}-{}-{}", DateUtil.now(),appName,name);
    }

    @PostMapping("/user")
    public UserModel user(@RequestBody UserModel userModel) {
        log.info("接收到请求：{}", userModel);
        userModel.setPhone("180****9036");
        return userModel;
    }
}
