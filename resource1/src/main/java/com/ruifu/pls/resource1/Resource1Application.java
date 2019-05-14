package com.ruifu.pls.resource1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Resource1Application {

    public static void main(String[] args) {
        SpringApplication.run(Resource1Application.class, args);
    }

}
