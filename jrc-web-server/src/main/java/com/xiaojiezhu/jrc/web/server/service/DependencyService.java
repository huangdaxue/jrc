package com.xiaojiezhu.jrc.web.server.service;

/**
 * Dependency service interface
 * @author xiaojie.zhu
 */
public interface DependencyService {

    /**
     * Add a dependency to an other version id
     * @param versionId
     * @param dependencyVersionId
     * @return 0 success, 1 exist,2 versionId equals dependencyVersionId
     */
    int addDependency(int versionId,int dependencyVersionId);
}
