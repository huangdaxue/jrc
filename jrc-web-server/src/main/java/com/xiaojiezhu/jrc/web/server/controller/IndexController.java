package com.xiaojiezhu.jrc.web.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    /**
     * index
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "/index.html";
    }
}
