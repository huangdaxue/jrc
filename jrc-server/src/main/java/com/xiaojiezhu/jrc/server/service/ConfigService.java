package com.xiaojiezhu.jrc.server.service;

import java.util.Map;

/**
 * @author xiaojie.zhu
 */
public interface ConfigService {


    /**
     * get the global with dependency config
     * @param group
     * @param unit
     * @param version
     * @param profile
     * @return
     */
    Map<String,?> getGlobalVersionConfig(String group, String unit, String version, String profile);
}
