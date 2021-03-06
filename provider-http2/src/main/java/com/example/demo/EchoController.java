package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.portable.ResponseHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EchoController {

    @PostMapping("/echo.do")
    @ResponseBody
    public String echo(@RequestParam("msg") String msg){
        log.info("service 接收到 {}", msg);
        return msg;
    }

}
