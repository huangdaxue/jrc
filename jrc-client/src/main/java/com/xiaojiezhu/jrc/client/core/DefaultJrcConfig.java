package com.xiaojiezhu.jrc.client.core;

import com.xiaojiezhu.jrc.client.JrcConfig;
import com.xiaojiezhu.jrc.client.core.store.ConfigStore;
import com.xiaojiezhu.jrc.client.core.store.SimpleConfigStore;

/**
 * @author xiaojie.zhu
 */
public class DefaultJrcConfig implements JrcConfig {

    private ConfigStore configStore;

    /**
     * load config file
     */
    public DefaultJrcConfig() {

    }

    public DefaultJrcConfig(String group,String unit,String version,String profile){
        ConfigStore configStore = new SimpleConfigStore(group,unit,version,profile);
        this.setConfigStore(configStore);
    }

    public void setConfigStore(ConfigStore configStore) {
        this.configStore = configStore;
    }

    @Override
    public String getConfig() {
        return null;
    }

    @Override
    public Object getObject(String key) {
        return null;
    }

    @Override
    public Object getObject(String key, Object defaultValue) {
        return null;
    }

    @Override
    public Integer getInt(String key) {
        return null;
    }

    @Override
    public Integer getInt(String key, Integer defaultValue) {
        return null;
    }

    @Override
    public Long getLong(String key) {
        return null;
    }

    @Override
    public Long getLong(String key, Long defaultValue) {
        return null;
    }

    @Override
    public String getString(String key) {
        return null;
    }

    @Override
    public String getString(String key, String defaultValue) {
        return null;
    }

    @Override
    public Double getDouble(String key) {
        return null;
    }

    @Override
    public Double getDouble(String key, Double defaultValue) {
        return null;
    }
}
