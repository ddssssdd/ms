package com.ruifu.pls.servicehijwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceHiJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiJwtApplication.class, args);
    }

}
