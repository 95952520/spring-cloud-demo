package com.xuchen.cloud.consumer;

import com.xuchen.cloud.consumer.service.ProducerRemote;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCloudConsumerHystrixApplicationTests {

    @Autowired
    ProducerRemote producerRemote;

    @Test
    public void contextLoads() {
        String s = producerRemote.hello("xuchen");
        log.info(s);
    }

}
