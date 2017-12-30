package com.xiaojiezhu.jrc.web.server.controller;

import com.xiaojiezhu.jrc.web.server.model.ServerStatus;
import com.xiaojiezhu.jrc.web.server.support.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * jrc cluster server report
 * @author xiaojie.zhu
 */
@RestController
@RequestMapping("/report")
public class ReportController {

    /**
     * return server status
     * @return server status
     */
    @ResponseBody
    @RequestMapping("/getServerStatus")
    public ServerStatus getServerStatus(){
        ServerStatus serverStatus = new ServerStatus(1,10,12);
        return serverStatus;
    }

}
