package com.ruifu.pls.consume2;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {



    @Autowired
    ResourceIndex resourceIndex;

    @RequestMapping("/index")
    public List<String> index(){
        List<String> results = new ArrayList<>();
        for(int i=0;i<20;i++){
            //String result = restTemplate.getForObject("http://RESOURCE1/v1/api/index",String.class);
            String result = resourceIndex.index();
            results.add(result);
        }
        return results;
    }
}
