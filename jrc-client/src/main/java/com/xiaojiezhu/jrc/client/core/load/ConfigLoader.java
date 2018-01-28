package com.xiaojiezhu.jrc.client.core.load;

import java.util.Map;

/**
 * @author xiaojie.zhu
 */
public abstract class ConfigLoader {
    protected String group;
    protected String unit;
    protected String version;
    protected String profile;

    public ConfigLoader(String group, String unit, String version, String profile) {
        this.group = group;
        this.unit = unit;
        this.version = version;
        this.profile = profile;
    }

    /**
     * load config by coord
     * @return
     */
    public abstract Map<String,Object> load()throws Exception;



}
