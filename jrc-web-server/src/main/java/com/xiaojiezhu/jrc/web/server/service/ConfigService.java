package com.xiaojiezhu.jrc.web.server.service;

import com.xiaojiezhu.jrc.model.Unit;
import com.xiaojiezhu.jrc.model.Version;
import com.xiaojiezhu.jrc.web.server.support.model.LimitResult;

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
    LimitResult listUnit(int index, int size, String unitName);


    /**
     * Add a version
     * @param version
     * @return
     */
    int addVersion(Version version);


    /**
     * list version
     * @param index
     * @param size
     * @param version
     * @param unitId
     * @param profile
     * @return
     */
    LimitResult listVersion(int index, int size,int unitId, String version,String profile);
}
