package com.xuchen.cloud.consumer.service;

import com.xuchen.cloud.model.base.Result;
import com.xuchen.cloud.model.user.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xuchen
 * @date 2019/08/19
 */
@FeignClient("producer")
public interface ProducerRemote {

    @GetMapping("hello")
    Result<String> hello(@RequestParam("name") String name);

    @PostMapping("user")
    Result<UserModel> user(UserModel userModel);
}
