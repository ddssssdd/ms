package com.ruifu.pls.consume1.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "fallbackService")
    public String hiService(){
        return restTemplate.getForObject("http://RESOURCE1/v1/api/index",String.class);
    }

    public String fallbackService(){
        return "Service is not available.";
    }
}
