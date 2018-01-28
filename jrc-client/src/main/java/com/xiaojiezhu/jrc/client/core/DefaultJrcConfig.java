package com.xiaojiezhu.jrc.client.core;

import com.xiaojiezhu.jrc.client.JrcConfig;
import com.xiaojiezhu.jrc.client.core.store.ConfigStore;
import com.xiaojiezhu.jrc.client.core.store.SimpleConfigStore;
import com.xiaojiezhu.jrc.client.coord.CoordLoader;
import com.xiaojiezhu.jrc.client.coord.DefaultCoordLoader;

/**
 * @author xiaojie.zhu
 */
public class DefaultJrcConfig implements JrcConfig {

    private ConfigStore configStore;
    private CoordLoader coordLoader = new DefaultCoordLoader();

    /**
     * load config file
     */
    public DefaultJrcConfig() {
        this.loadDefaultJrc();
    }

    /**
     * load the default config
     */
    private void loadDefaultJrc(){
        String group = coordLoader.getGroup();
        String unit = coordLoader.getUnit();
        String version = coordLoader.getVersion();
        String profile = coordLoader.getProfile();

        ConfigStore configStore = new SimpleConfigStore(group,unit,version,profile);
        this.setConfigStore(configStore);
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
