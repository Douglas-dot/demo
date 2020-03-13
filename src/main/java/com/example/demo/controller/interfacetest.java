package com.example.demo.controller;
import com.example.demo.utils.HttpAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class interfacetest {
    @Autowired
    private HttpAPIService httpAPIService ;

    @RequestMapping("/demoShow")
    public String hello(){


        String str = null;
        try {
            str = httpAPIService.doGet("http://5c92dbfae7b1a00014078e61.mockapi.io/owners");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return str;
    }


}
