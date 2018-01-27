package com.xiaojiezhu.jrc.client;

import com.xiaojiezhu.jrc.client.core.DefaultJrcConfig;

/**
 * @author xiaojie.zhu
 */
public class JrcConfigFactory {

    public static JrcConfig getJrcConfig(){
        return new DefaultJrcConfig();
    }
}
