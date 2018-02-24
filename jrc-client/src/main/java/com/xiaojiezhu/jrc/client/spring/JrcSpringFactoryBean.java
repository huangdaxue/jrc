package com.xiaojiezhu.jrc.client.spring;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.support.PropertiesLoaderSupport;

import java.util.Properties;

/**
 * inject config in spring framework
 * @author xiaojie.zhu
 */
public class JrcSpringFactoryBean extends PropertiesLoaderSupport implements FactoryBean<Properties>,InitializingBean {
    private boolean singleton = true;
    private PropertiesCreator propertiesCreator = PropertiesCreatorFactory.getPropertiesCreator();
    private Properties instance;

    @Override
    public Properties getObject() throws Exception {
        if (this.singleton) {
            return this.instance;
        }
        else {
            return createProperties();
        }
    }

    @Override
    public Class<?> getObjectType() {
        return Properties.class;
    }

    @Override
    public boolean isSingleton() {
        return this.singleton;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (this.singleton) {
            this.instance = createProperties();
        }
    }

    private Properties createProperties() {
        Properties properties = propertiesCreator.getProperties();
        return properties;
    }
}
