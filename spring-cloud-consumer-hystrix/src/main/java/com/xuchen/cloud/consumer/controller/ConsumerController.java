package com.xuchen.cloud.consumer.controller;

import cn.hutool.json.JSONUtil;
import com.xuchen.cloud.consumer.service.ProducerRemote;
import com.xuchen.cloud.model.user.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuchen
 * @date 2019/08/19
 */
@Slf4j
@RestController
public class ConsumerController {

    @Autowired
    ProducerRemote producerRemote;

    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        log.info("consumer接收到http请求:{}", name);
        String reuslt = producerRemote.hello(name);
        log.info("consumer接收到producer响应:{}", reuslt);
        return reuslt;
    }

    @GetMapping("/user")
    public UserModel user(UserModel userModel) {
        log.info("consumer接收到http请求:{}", JSONUtil.toJsonStr(userModel));
        UserModel user = producerRemote.user(userModel);
        log.info("consumer接收到响应:{}", JSONUtil.toJsonStr(user));
        return user;
    }
}
