package com.xiaojiezhu.jrc.web.server.controller;

import com.xiaojiezhu.jrc.model.Dependency;
import com.xiaojiezhu.jrc.web.server.service.DependencyService;
import com.xiaojiezhu.jrc.web.server.support.ResponseBody;
import com.xiaojiezhu.jrc.web.server.support.model.LimitResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

    /**
     * Get the selected version config ids
     * @param versionId the version config id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getDependencyVersionId")
    public List<Long> getDependencyVersionId(@RequestParam("versionId")int versionId){
        return dependencyService.getDependencyVersionId(versionId);
    }

    /**
     * Get the selected version config
     * @param versionId the version id
     * @param index
     * @param size
     * @return
     */
    @ResponseBody
    @RequestMapping("/getDependencyList")
    public LimitResult getDependencyList(@RequestParam("versionId")int versionId, @RequestParam("index")int index, @RequestParam("size")int size){
        return dependencyService.getDependencyList(versionId,index,size);
    }

    /**
     * Get the global version config, with dependency version config
     * @param versionId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getGlobalVersionConfig")
    public Map<String, String> getGlobalVersionConfig(@RequestParam("versionId")int versionId){
        return dependencyService.getGlobalVersionConfig(versionId);
    }
}
