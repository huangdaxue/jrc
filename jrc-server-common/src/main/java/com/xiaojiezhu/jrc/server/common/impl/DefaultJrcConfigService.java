package com.xiaojiezhu.jrc.server.common.impl;

import com.xiaojiezhu.jrc.common.exception.UnSupportConfigException;
import com.xiaojiezhu.jrc.common.resolve.DefaultConfigResolve;
import com.xiaojiezhu.jrc.server.common.JrcConfigService;
import com.xiaojiezhu.jrc.server.dao.mysql.DependencyDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xiaojie.zhu
 */
@Service
public class DefaultJrcConfigService implements JrcConfigService {
    public final static Logger LOG = LoggerFactory.getLogger(DefaultJrcConfigService.class);

    @Autowired
    private DependencyDao dependencyDao;


    @Override
    public Map<String, String> getGlobalVersionConfig(int versionId) {
        DefaultConfigResolve resolve = new DefaultConfigResolve();
        resolveConfig(resolve,versionId);
        Map<String, String> configContent = resolve.resolve();
        return configContent;
    }

    /**
     * repeat read config dependency config data
     * @param configResolve
     * @param versionId
     */
    private void resolveConfig(DefaultConfigResolve configResolve,int versionId){
        String content = dependencyDao.getVersionConfigContent(versionId);
        if(content != null){
            try {
                configResolve.addConfig(content);
            } catch (UnSupportConfigException e) {
                LOG.error("error config data format,it is:" + content);
            }
        }

        List<Integer> dependencyIds = dependencyDao.getDependencyId(versionId);
        if(dependencyIds != null && dependencyIds.size() > 0){
            for(int i = 0 ; i < dependencyIds.size() ; i ++){
                Integer dependencyId = dependencyIds.get(i);
                if(dependencyId != null){
                    resolveConfig(configResolve,dependencyId);
                }

            }
        }

    }
}
