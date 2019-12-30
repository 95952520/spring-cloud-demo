package com.xuchen.cloud.consumer.controller;

import cn.hutool.json.JSONUtil;
import com.xuchen.cloud.consumer.service.ProducerRemote;
import com.xuchen.cloud.model.base.Result;
import com.xuchen.cloud.model.user.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @GetMapping(value = "/hello",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<String> hello(@RequestParam("name") String name) {
        log.info("consumer接收到http请求:{}", name);
        Result<String> result = producerRemote.hello(name+"-"+System.currentTimeMillis());
        log.info("consumer接收到producer响应:{}", result);
        return result;
    }

    @GetMapping(value = "/user",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @GetMapping("/user")
    public Result<UserModel> user(UserModel userModel) {
        log.info("consumer接收到http请求:{}", JSONUtil.toJsonStr(userModel));
        Result<UserModel> result = producerRemote.user(userModel);
        log.info("consumer接收到producer响应:{}", JSONUtil.toJsonStr(result));
        return result;
    }
}
