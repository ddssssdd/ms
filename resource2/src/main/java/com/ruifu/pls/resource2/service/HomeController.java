package com.ruifu.pls.resource2.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    @RequestMapping("/index")
    public String index(){
        return "this is resource server 2";
    }

    @RequestMapping("/user")
    public Principal user(Principal user){
        return user;
    }
}
