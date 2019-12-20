package com.xuchen.cloud.consumer.service.fallback;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.xuchen.cloud.consumer.service.ProducerRemote;
import com.xuchen.cloud.model.user.UserModel;
import org.springframework.stereotype.Component;

/**
 * @author Edwin
 * @date 2019/12/20
 */
@Component
public class ProducerRemoteHystrix implements ProducerRemote {
    @Override
    public String hello(String name) {
        return StrUtil.format("{}-{}-{}", DateUtil.now(),name,"fallback");
    }

    @Override
    public UserModel user(UserModel userModel) {
        return null;
    }
}
