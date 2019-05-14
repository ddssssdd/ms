package com.ruifu.pls.resource1.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class IndexApiController {


    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/index")
    public String index(){
        return "Version 1.0, running on port:"+serverPort;
    }
}
