package com.xuchen.cloud.consumer.service;

import com.xuchen.cloud.model.user.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xuchen
 * @date 2019/08/19
 */
@FeignClient("producer")
public interface ProducerRemoteService {

    @GetMapping("hello")
    String hello(@RequestParam("name") String name);

    @GetMapping("user")
    UserModel user(UserModel userModel);
}
