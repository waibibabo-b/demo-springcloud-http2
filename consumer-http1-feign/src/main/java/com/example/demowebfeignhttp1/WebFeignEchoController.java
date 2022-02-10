package com.example.demowebfeignhttp1;

import com.example.demowebfeignhttp1.feign.EchoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;

@Slf4j
@RestController
public class WebFeignEchoController {

    @Autowired
    private EchoService echoService;

    @PostMapping("/echo.do")
//    @ResponseBody
    public Object echo(@RequestBody Map<String,Object>params){
        log.info("web feign 接收到 {}", params.toString());
        Instant start = Instant.now();
        String str = echoService.echo(params.get("msg").toString());
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        return "FeignClient的http/2========>"+timeElapsed+"毫秒======>"+str;
    }

}
