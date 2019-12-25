package com.xuchen.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    /*
        https://windmt.com/2018/05/07/spring-cloud-13-spring-cloud-gateway-router/
        这样请求即可：http://localhost:8040/consumer/hello?name=test
    */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/consumer/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:8020//CONUSMER")
                        .id("consumer_route")
                )
                .build();
    }

}
