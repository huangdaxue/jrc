package com.xiaojiezhu.jrc.server.dao.mysql;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author xiaojie.zhu
 */
public interface DependencyDao {

    @Select("select count(1) from dependency where version_id=${versionId} and dependency_id=${dependencyVersionId}")
    boolean versionDependencyExist(@Param("versionId") int versionId, @Param("dependencyVersionId") int dependencyVersionId);


    @Insert("insert into dependency(version_id,dependency_id,create_time) " +
            "values(${versionId},${dependencyVersionId},now())")
    boolean addDependency(@Param("versionId") int versionId, @Param("dependencyVersionId") int dependencyVersionId);

}
