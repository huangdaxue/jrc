package com.xiaojiezhu.jrc.web.server.service.helper;

import com.xiaojiezhu.jrc.model.Unit;
import com.xiaojiezhu.jrc.model.Version;

import java.util.List;

/**
 * @author xiaojie.zhu
 */
public interface ConfigHelper {
    /**
     * The unit is exist
     * @param unit
     * @return If true,then exist
     */
    boolean isExistUnit(Unit unit);

    /**
     * Add unit to database
     * @param unit
     */
    void addUnit(Unit unit);

    /**
     * version is exists
     * @param version
     * @return
     */
    boolean isExistVersion(Version version);


    /**
     * add version
     * @param version
     */
    void addVersion(Version version);
}
