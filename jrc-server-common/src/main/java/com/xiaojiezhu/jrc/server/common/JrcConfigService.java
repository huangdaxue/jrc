package com.xiaojiezhu.jrc.server.common;

import java.util.Map;

/**
 * @author xiaojie.zhu
 */
public interface JrcConfigService {

    /**
     * Get the global version config, with dependency version config
     * @param versionId
     * @return
     */
    Map<String, String> getGlobalVersionConfig(int versionId);
}
