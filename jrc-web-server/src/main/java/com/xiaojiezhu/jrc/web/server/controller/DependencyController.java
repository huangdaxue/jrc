package com.xiaojiezhu.jrc.web.server.controller;

import com.xiaojiezhu.jrc.web.server.service.DependencyService;
import com.xiaojiezhu.jrc.web.server.support.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * control dependency
 * @author xiaojie.zhu
 */
@RequestMapping("/dependency")
@RestController
public class DependencyController {

    @Autowired
    private DependencyService dependencyService;

    /**
     * Add a dependency to other config version
     * @param versionId The config version id
     * @param dependencyId The dependency version id
     * @return 0 success, 1 exist,2 versionId equals dependencyVersionId
     */
    @ResponseBody
    @RequestMapping("/addDependency")
    public int addDependency(@RequestParam("versionId")int versionId,@RequestParam("dependencyId")int dependencyId){
        int code = dependencyService.addDependency(versionId, dependencyId);
        return code;
    }
}
