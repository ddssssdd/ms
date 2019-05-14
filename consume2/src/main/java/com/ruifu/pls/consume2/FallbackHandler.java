package com.ruifu.pls.consume2;


import org.springframework.stereotype.Component;

@Component
public class FallbackHandler implements ResourceIndex{

    @Override
    public String index() {
        return "Server is broken.";
    }
}
