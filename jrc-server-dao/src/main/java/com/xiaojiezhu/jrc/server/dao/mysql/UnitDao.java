package com.xiaojiezhu.jrc.server.dao.mysql;

import com.xiaojiezhu.jrc.model.Unit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xiaojie.zhu
 */
public interface UnitDao {

    @Select("select * from unit where group_=#{group} and unit=#{unit}")
    Unit findUnit(@Param("group") String group, @Param("unit") String unit);

    @Insert("insert into unit(group_,unit,description_,create_time,update_time)\n" +
            "values(#{group},#{unit},#{description},now(),now())")
    boolean insertUnit(Unit unit);

    /**
     * list user,right like search by unitName
     * @param start
     * @param size
     * @param unitName
     * @return
     */
    List<Unit> listUnit(@Param("start") int start, @Param("size") int size, @Param("unitName") String unitName);

    /**
     * count by unitName,if empty count all
     * @param unitName
     * @return
     */
    long countUnit(@Param("unitName")String unitName);
}
