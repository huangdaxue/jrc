package com.xiaojiezhu.jrc.web.server.service.impl;

import com.xiaojiezhu.jrc.server.dao.mysql.DependencyDao;
import com.xiaojiezhu.jrc.web.server.service.DependencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaojie.zhu
 */
@Service
public class DependencyServiceImpl implements DependencyService{
    public final static Logger LOG = LoggerFactory.getLogger(DependencyServiceImpl.class);
    @Autowired
    private DependencyDao dependencyDao;

    @Override
    public int addDependency(int versionId, int dependencyVersionId) {
        boolean exist = dependencyDao.versionDependencyExist(versionId, dependencyVersionId);
        if(exist){
            LOG.warn("Add dependency fail,the versionId:" + versionId +  " ,and dependencyId:" + dependencyVersionId + " is exist");
            return 1;
        }else if(versionId == dependencyVersionId){
            LOG.warn("Add dependency fail,the versionId can not equals dependencyVersionId");
            return 2;
        }else {
            dependencyDao.addDependency(versionId,dependencyVersionId);
            return 0;
        }
    }
}
