package com.xiaojiezhu.jrc.client.spring;

import com.xiaojiezhu.jrc.client.JrcConfig;
import com.xiaojiezhu.jrc.client.JrcConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author xiaojie.zhu
 */
public class JrcSpringConfiguration implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    public final static Logger LOG = LoggerFactory.getLogger(JrcSpringConfiguration.class);


    private final static String DISABLE_NAME = "jrc.enable";
    /**
     * the name of config
     */
    private final static String CONFIG_NAME = "jrc";
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        String status = System.getenv(DISABLE_NAME);
        if(Boolean.FALSE.toString().equals(status)){
            LOG.warn("the jrc config is disable");
            return;
        }
        JrcConfig jrcConfig = JrcConfigFactory.getJrcConfig();
        ConfigurableEnvironment environment = event.getEnvironment();
        Map<String, ?> configMap = jrcConfig.getConfigMap();

        MapPropertySource mapPropertySource = new MapPropertySource(CONFIG_NAME, (Map<String, Object>) configMap);
        environment.getPropertySources().addFirst(mapPropertySource);
    }
}
