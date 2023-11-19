package com.santander.testkafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TestController {

    private AtomicInteger semaphore = new AtomicInteger(0);

    @Autowired
    private StreamBridge streamBridge;

    @GetMapping(value = "/test")
    public void sequentialSimple() {
            streamBridge.send("sendTestData-out-0", "testMessage_" + semaphore.getAndIncrement());
    }

}
