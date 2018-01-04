package com.xiaojiezhu.jrc.web.server.service.helper.impl;

import com.xiaojiezhu.jrc.model.Unit;
import com.xiaojiezhu.jrc.server.dao.mysql.UnitDao;
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

    @Override
    public boolean isExistUnit(Unit unit) {
        Unit db = unitDao.findUnit(unit.getGroup(), unit.getUnit());
        return db != null;
    }

    @Override
    public void addUnit(Unit unit) {
        boolean r = unitDao.insertUnit(unit);
    }

}
