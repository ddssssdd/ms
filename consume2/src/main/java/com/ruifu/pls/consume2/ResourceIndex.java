package com.ruifu.pls.consume2;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "resource1",fallback = FallbackHandler.class)
public interface ResourceIndex {
    @RequestMapping(value = "/v1/api/index",method = RequestMethod.GET)
    String index();
}
