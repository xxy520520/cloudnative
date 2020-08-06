package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Edwin Xu on 7/31/2020 10:59 AM
 */
@RestController
public class MyController {
    @GetMapping("/hello")
    @AccessLimit(maxCount = 100)
    public String hello(){
//        try {
//            Thread.sleep(1000);
//        }catch (Exception e){
//
//        }
        return "hello";
    }
}
