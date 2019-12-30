package com.xuchen.cloud.gateway.controller;

import com.xuchen.cloud.model.base.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public Result fallback(){
        return Result.fail("服务暂时不可用");
    }
}
