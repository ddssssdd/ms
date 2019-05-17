package com.ruifu.pls.resource1.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
@RefreshScope
public class IndexApiController {

    @Value("${scope.refresh}")
    public String profile;

    @RequestMapping("/profile")
    public String profile(){
        return profile;
    }

    @Value("${server.port}")
    private String serverPort;


    @Value("${spring.datasource.password}")
    private String password;

    @RequestMapping("/index")
    public String index(){
        return "Version 1.0, running on port: "+serverPort+"-"+password;
    }
}
