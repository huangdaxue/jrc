package com.xiaojiezhu.jrc.web.server.service.helper.impl;

import com.xiaojiezhu.jrc.model.Unit;
import com.xiaojiezhu.jrc.model.Version;
import com.xiaojiezhu.jrc.server.dao.mysql.UnitDao;
import com.xiaojiezhu.jrc.server.dao.mysql.VersionDao;
import com.xiaojiezhu.jrc.web.server.service.helper.ConfigHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaojie.zhu
 */
@Service
public class DefaultConfigHelper implements ConfigHelper {

    @Autowired
    private UnitDao unitDao;
    @Autowired
    private VersionDao versionDao;

    @Override
    public boolean isExistUnit(Unit unit) {
        Unit db = unitDao.findUnit(unit.getGroup(), unit.getUnit());
        return db != null;
    }

    @Override
    public void addUnit(Unit unit) {
        boolean r = unitDao.insertUnit(unit);
    }

    @Override
    public boolean isExistVersion(Version version) {
        Version db = versionDao.findVersion(version.getGroup(),version.getUnit(), version.getVersion(),version.getProfile());
        return db != null;
    }

    @Override
    public void addVersion(Version version) {
        versionDao.insertVersion(version);
    }

}
