package com.xiaojiezhu.jrc.server.dao.mysql;

import com.xiaojiezhu.jrc.model.Dependency;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xiaojie.zhu
 */
public interface DependencyDao {

    @Select("select count(1) from dependency where version_id=${versionId} and dependency_id=${dependencyVersionId}")
    boolean versionDependencyExist(@Param("versionId") int versionId, @Param("dependencyVersionId") int dependencyVersionId);


    @Insert("insert into dependency(version_id,dependency_id,create_time) " +
            "values(${versionId},${dependencyVersionId},now())")
    boolean addDependency(@Param("versionId") int versionId, @Param("dependencyVersionId") int dependencyVersionId);

    /**
     * Get the selected version config ids
     * @param versionId the config version id
     * @return
     */
    @Select("select dependency_id from dependency where version_id=${versionId}")
    List<Long> getDependencyVersionId(@Param("versionId") int versionId);

    /**
     * Limit get the dependency config version info
     * @param versionId the version id
     * @param start
     * @param size
     * @return
     */
    @Select("select b.id as 'version_id',c.group_,c.unit,b.version_,b.profile_,b.description as 'version_description' from dependency a left join version b on a.dependency_id=b.id left join unit c on b.unit_id=c.id\n" +
            "where a.version_id=${versionId} order by a.create_time desc limit ${start},${size}")
    List<Dependency> getDependencyList(@Param("versionId") int versionId, @Param("start") int start, @Param("size") int size);

    /**
     * Count the dependency
     * @param versionId
     * @return
     */
    @Select("select count(1) from dependency a where a.version_id=${versionId}")
    long countDependency(@Param("versionId") int versionId);
}
