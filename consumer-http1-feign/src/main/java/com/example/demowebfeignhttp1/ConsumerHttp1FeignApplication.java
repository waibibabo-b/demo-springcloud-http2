package com.example.demowebfeignhttp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class ConsumerHttp1FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHttp1FeignApplication.class, args);
    }

}
