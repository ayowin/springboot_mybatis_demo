package com.wz.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wz.springboot.services.DemoService;

@Controller
public class DemoController {
    
    @Autowired
    private DemoService demoServiceImpl;

    @RequestMapping("/")
    public String index() {
	return "index";
    }
    
    @ResponseBody
    @RequestMapping(value="/mybatis",produces="text/plain;charset=UTF-8")
    public String mybatis() {
	return demoServiceImpl.selectedUserById(1);
    }
    
}
