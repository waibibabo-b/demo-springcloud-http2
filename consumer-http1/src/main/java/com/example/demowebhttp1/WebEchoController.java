package com.example.demowebhttp1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;

@Slf4j
@RestController
public class WebEchoController {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/echo.do")
    public String echo(@RequestBody Map<String,Object> params ){
        log.info("web 接收到 {}", params.get("msg"));


        Instant start = Instant.now();
        RequestEntity<?> entity = RequestEntity
                .post(URI.create("http://provider-http1:8062/echo.do"))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body("msg="+params.get("msg").toString());
        String str =restTemplate.exchange(entity, String.class).getBody();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        return "restTemplate的http/1========>"+timeElapsed+"毫秒======>"+str;
    }
}
