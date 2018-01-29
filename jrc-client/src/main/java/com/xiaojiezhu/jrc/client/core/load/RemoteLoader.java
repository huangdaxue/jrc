package com.xiaojiezhu.jrc.client.core.load;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.xiaojiezhu.jrc.client.MetaConfig;
import com.xiaojiezhu.jrc.client.exception.LoadConfigException;
import com.xiaojiezhu.jrc.kit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author xiaojie.zhu
 */
class RemoteLoader extends ConfigLoader {
    public final static Logger LOG = LoggerFactory.getLogger(RemoteLoader.class);
    public final static Charset UTF8 = Charset.forName("UTF-8");


    public RemoteLoader(String group, String unit, String version, String profile) {
        super(group, unit, version, profile);
    }

    @Override
    public ConfigResult load()throws Exception {
        LOG.debug("request jrc-server...");
        HttpRequest.CloseableResponse closeableResponse = null;
        String content = null;
        try {
            closeableResponse = HttpRequest.Builder.newBuilder().url(MetaConfig.getServerUrl() + "/config/getConfig").post().json().stream(getRequestParams().getBytes(UTF8)).build().requestConnection();
            InputStream inputStream = closeableResponse.getInputStream();
            content = IOUtil.toString(inputStream);
        } catch (Exception e) {
            LOG.error("load jrc-server error , " + e.getMessage());
            throw new LoadConfigException(e);
        } finally {
            CloseUtil.close(closeableResponse);
        }
        LOG.debug("jrc-server response:" + content);
        Result<StateConfig> result = JSON.parseObject(content, new TypeReference<Result<StateConfig>>() {
        });
        if(result.getCode() == 0){
            StateConfig stateConfig = result.getData();
            ConfigResult configResult = new ConfigResult();
            if(stateConfig.isHasChange()){
                //has change
                configResult.setCode(1);
            }else{
                configResult.setCode(0);
            }
            configResult.setData(stateConfig.getConfig());
            configResult.setGroup(group);
            configResult.setUnit(unit);
            configResult.setVersion(version);
            configResult.setProfile(profile);
            return configResult;
        }else{
            LOG.error("request jrc-server fail , " + result.getMsg());
            throw new LoadConfigException(result.getMsg());
        }

    }

    private String getRequestParams(){
        TreeMap<String,Object> params = new TreeMap<>();
        params.put("group",group);
        params.put("unit",unit);
        params.put("version",version);
        params.put("profile",profile);
        params.put("time",System.currentTimeMillis());
        params.put("random", RandomUtil.random(8));

        String sign = SignUtil.sign(params, MetaConfig.getJrcKey());
        params.put("sign",sign);
        return JSON.toJSONString(params);
    }
}
