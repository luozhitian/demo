package com.example.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
//@NacosPropertySource(dataId = "ntc",autoRefreshed = true)
public class ConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumeApplication.class, args);
    }

}
