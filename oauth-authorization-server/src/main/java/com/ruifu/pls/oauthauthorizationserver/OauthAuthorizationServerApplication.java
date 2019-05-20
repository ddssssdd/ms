package com.ruifu.pls.oauthauthorizationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ruifu.pls.oauthauthorizationserver")
public class OauthAuthorizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthAuthorizationServerApplication.class, args);
    }

}
