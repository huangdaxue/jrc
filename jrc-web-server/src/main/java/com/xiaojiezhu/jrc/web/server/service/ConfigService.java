package com.xiaojiezhu.jrc.web.server.service;

import com.xiaojiezhu.jrc.model.Unit;

import java.util.List;

/**
 * @author xiaojie.zhu
 */
public interface ConfigService {

    /**
     * Add a unit
     * @param unit unit define
     * @return 0 success, 1 unit exist
     */
    int addUnit(Unit unit);

    /**
     * list unit
     * @param index
     * @param size
     * @param unitName
     * @return
     */
    List<Unit> listUnit(int index, int size, String unitName);
}
