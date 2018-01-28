package com.xiaojiezhu.jrc.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.xiaojiezhu.jrc.common.cache.Cache;
import com.xiaojiezhu.jrc.model.Version;
import com.xiaojiezhu.jrc.server.common.JrcConfigService;
import com.xiaojiezhu.jrc.server.service.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaojie.zhu
 */
@Service
public class ConfigServiceImpl implements ConfigService{
    private final static Charset UTF8 = Charset.forName("UTF-8");
    public final static Logger LOG = LoggerFactory.getLogger(ConfigServiceImpl.class);
    @Autowired
    private JrcConfigService jrcConfigService;
    @Autowired
    private Cache cache;

    @Override
    public Map<String, ?> getGlobalVersionConfig(String group, String unit, String version, String profile) {
        String key = getConfigKey(group, unit, version, profile);
        String configContent = cache.getString(key);
        if(configContent == null){
            LOG.debug("load config from database");
            Map<String, ?> globalVersionConfig = jrcConfigService.getGlobalVersionConfig(group, unit, version, profile);
            String content = JSON.toJSONString(globalVersionConfig);
            cache.set(key,content);
            return globalVersionConfig;
        }else{
            LOG.debug("load config from cache");
            Map<String,Object> data = JSON.parseObject(configContent, HashMap.class);
            return data;
        }
    }


    private String getConfigKey(String group, String unit, String version, String profile) {
        if(group == null || unit == null || version == null || profile == null){
            throw new NullPointerException("the pointer error , group:" + group + " , unit:" + unit + " , version:" + version + " , profile:" + profile);
        }
        String key = group + unit + version + profile;
        try {
            key = URLEncoder.encode(key,"UTF-8");
            return key;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new NullPointerException("key is null");
        }
    }
}
