package com.xiaojiezhu.jrc.web.server.controller;

import com.xiaojiezhu.jrc.common.BeanUtil;
import com.xiaojiezhu.jrc.model.Unit;
import com.xiaojiezhu.jrc.web.server.service.ConfigService;
import com.xiaojiezhu.jrc.web.server.support.ResponseBody;
import com.xiaojiezhu.jrc.web.server.support.exception.ex.NoticeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author xiaojie.zhu
 */
@RequestMapping("/config")
@Controller
public class ConfigController {
    public final static Logger LOG = LoggerFactory.getLogger(ConfigController.class);

    @Autowired
    private ConfigService configService;

    @ResponseBody
    @RequestMapping("/addUnit")
    public int addUnit(@RequestBody()Unit unit){
        BeanUtil.ValidateResult validateResult = BeanUtil.validateBean(unit);
        if(validateResult.getErrorNum() > 0){
            LOG.warn(validateResult.getErrorInfo());
            throw new NoticeException(validateResult.getErrorInfo());
        }
        int resultCode = configService.addUnit(unit);
        return resultCode;
    }

    @ResponseBody
    @RequestMapping("/listUnit")
    public List<Unit> listUnit(@RequestParam("index")int index,@RequestParam("size")int size,@RequestParam("unitName")String unitName){
        if(size > 30){
            throw new RuntimeException("out query size");
        }
        return configService.listUnit(index,size,unitName);
    }
}
