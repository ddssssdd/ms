package com.ruifu.pls.serviceauthjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableEurekaClient
public class ServiceAuthJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthJdbcApplication.class, args);
    }

}
