package com.xiaojiezhu.jrc.client.util;

import com.xiaojiezhu.jrc.client.JrcConfigCache;
import com.xiaojiezhu.jrc.client.core.DefaultJrcConfigCache;

/**
 * @author xiaojie.zhu
 */
public class FlushUtil {
    private static final JrcConfigCache JRC_CONFIG_CACHE = new DefaultJrcConfigCache();


    /**
     * flush the jrc-server config cache
     */
    public static void flushCache(){
        JRC_CONFIG_CACHE.flushCache();
    }
}
