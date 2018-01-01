package com.xiaojiezhu.jrc.web.server.service.impl;

import com.xiaojiezhu.jrc.model.Unit;
import com.xiaojiezhu.jrc.server.dao.mysql.UnitDao;
import com.xiaojiezhu.jrc.web.server.service.ConfigService;
import com.xiaojiezhu.jrc.web.server.service.helper.ConfigHelper;
import com.xiaojiezhu.jrc.web.server.support.exception.ex.UnitExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaojie.zhu
 */
@Service
public class ConfigServiceImpl implements ConfigService {
    public final static Logger LOG = LoggerFactory.getLogger(ConfigServiceImpl.class);
    @Autowired
    private ConfigHelper configHelper;
    @Autowired
    private UnitDao unitDao;

    @Override
    public int addUnit(Unit unit) {
        boolean exist = configHelper.isExistUnit(unit);
        if(exist){
            LOG.warn("group:" + unit.getGroup() + ",unit:" + unit.getUnit() + " is exist");
            return 1;
        }else {
            configHelper.addUnit(unit);
            return 0;
        }
    }

    @Override
    public List<Unit> listUnit(int index, int size, String unitName) {
        int start = (index - 1) * size;
        return null;
    }
}
