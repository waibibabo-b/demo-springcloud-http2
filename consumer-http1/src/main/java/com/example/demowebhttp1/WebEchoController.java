package com.example.demowebhttp1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.Duration;
import java.time.Instant;

@Slf4j
@RestController
public class WebEchoController {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/echo.do")
    @ResponseBody
    public String echo(String msg){
        log.info("web 接收到 {}", msg);


        Instant start = Instant.now();
        RequestEntity<?> entity = RequestEntity
                .post(URI.create("http://provider-http1/echo.do"))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body("msg="+msg);
        String str =restTemplate
                .exchange(entity, String.class)
                .getBody();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        return "restTemplate的http/1========>"+timeElapsed+"毫秒======>"+str;
    }
}
