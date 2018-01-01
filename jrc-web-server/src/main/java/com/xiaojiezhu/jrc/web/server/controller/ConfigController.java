package com.xiaojiezhu.jrc.web.server.controller;

import com.xiaojiezhu.jrc.model.Unit;
import com.xiaojiezhu.jrc.web.server.support.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaojie.zhu
 */
@RequestMapping("/config")
@Controller
public class ConfigController {

    @ResponseBody
    @RequestMapping("/addUnit")
    public void addUnit(@RequestBody()Unit unit){
        System.out.println(unit);
    }
}
