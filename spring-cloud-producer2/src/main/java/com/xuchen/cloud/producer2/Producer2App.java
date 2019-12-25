package com.xuchen.cloud.producer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Producer2App {

    public static void main(String[] args) {
        SpringApplication.run(Producer2App.class, args);
    }

}
