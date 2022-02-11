package com.example.demowebhttp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerHttp1Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHttp1Application.class, args);
    }

}
