package com.xuchen.cloud.producer.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.xuchen.cloud.model.base.Result;
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
    public Result<String> hello(@RequestParam String name) {
        log.info("{} 接收到请求：{}",appName, name);
        return Result.success(StrUtil.format("{}-{}-{}", DateUtil.now(),appName,name));
    }

    @PostMapping("/user")
    public Result user(@RequestBody UserModel userModel) {
        log.info("{} 接收到请求：{}",appName, userModel);
        userModel.setPhone("180****9036");
        return Result.success(userModel);
    }
}
