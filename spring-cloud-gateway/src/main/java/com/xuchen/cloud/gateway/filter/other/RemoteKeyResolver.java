package com.xuchen.cloud.gateway.filter.other;

import cn.hutool.json.JSONUtil;
import cn.hutool.system.HostInfo;
import cn.hutool.system.SystemUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author xuchen
 * @date 2019/12/25
 * 根据id限流
 */
@Slf4j
public class RemoteKeyResolver implements KeyResolver {

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        String hostAddress = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
        HostInfo hostInfo = SystemUtil.getHostInfo();
        log.info("hostAddress:{}", hostAddress);
        log.info("hostInfo:{}", JSONUtil.toJsonStr(hostInfo));
        return Mono.just(hostAddress);
    }
}
