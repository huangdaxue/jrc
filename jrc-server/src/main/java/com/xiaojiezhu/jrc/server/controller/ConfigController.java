package com.xiaojiezhu.jrc.server.controller;

import com.xiaojiezhu.jrc.server.common.JrcConfigService;
import com.xiaojiezhu.jrc.server.util.RequestKit;
import com.xiaojiezhu.jrc.web.server.support.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author xiaojie.zhu
 */
@RestController
@RequestMapping("/config")
public class ConfigController {
    public final static Logger LOG = LoggerFactory.getLogger(ConfigController.class);

    @Autowired
    private JrcConfigService jrcConfigService;

    /**
     * flush config cache
     */
    @ResponseBody
    @RequestMapping("/flushCache")
    public void flushCache(){

    }

    /**
     * get version config
     * @return
     */
    @ResponseBody
    @RequestMapping("/getConfig")
    public Map<String, String> getConfig(){
        String content = RequestKit.get();
        LOG.info(content);
        Map<String, String> globalVersionConfig = jrcConfigService.getGlobalVersionConfig(9);
        return globalVersionConfig;
    }
}
