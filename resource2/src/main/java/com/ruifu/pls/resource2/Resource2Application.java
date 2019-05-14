package com.ruifu.pls.resource2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Resource2Application {

    public static void main(String[] args) {
        SpringApplication.run(Resource2Application.class, args);
    }

}
