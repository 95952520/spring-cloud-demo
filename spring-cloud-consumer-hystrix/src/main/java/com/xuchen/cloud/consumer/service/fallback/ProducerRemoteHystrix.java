package com.xuchen.cloud.consumer.service.fallback;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.xuchen.cloud.consumer.service.ProducerRemote;
import com.xuchen.cloud.model.base.Result;
import com.xuchen.cloud.model.user.UserModel;
import org.springframework.stereotype.Component;

/**
 * @author xuchen
 * @date 2019/12/20
 */
@Component
public class ProducerRemoteHystrix implements ProducerRemote {
    @Override
    public Result<String> hello(String name) {
        return Result.fail(StrUtil.format("{}-{}-{}", DateUtil.now(),name,"fallback"));
    }

    @Override
    public Result<UserModel> user(UserModel userModel) {
        return Result.fail();
    }
}
