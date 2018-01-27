package com.xiaojiezhu.jrc.client.core.store;

import com.alibaba.fastjson.JSON;
import com.xiaojiezhu.jrc.client.MetaConfig;
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
public class SimpleConfigStore implements ConfigStore {
    public final static Logger LOG = LoggerFactory.getLogger(SimpleConfigStore.class);
    private final static Charset UTF8 = Charset.forName("UTF-8");
    private String group;
    private String unit;
    private String version;
    private String profile;

    @Override
    public Map<String, String> getConfig() {
        return null;
    }

    public SimpleConfigStore(String group, String unit, String version, String profile) {
        this.group = group;
        this.unit = unit;
        this.version = version;
        this.profile = profile;
        LOG.info("jrc config,group:" + group + " ,unit:" + unit + ", version:" + version + " ,profile:" + profile);
        this.init();
    }

    private void loadRemoteData() throws IOException {
        LOG.debug("request jrc-server...");
        HttpRequest.CloseableResponse closeableResponse = HttpRequest.Builder.newBuilder().url(MetaConfig.getServerUrl() + "/config/getConfig").post().json().stream(getRequestParams().getBytes(UTF8)).build().requestConnection();
        InputStream inputStream = closeableResponse.getInputStream();
        String content = IOUtil.toString(inputStream);
        LOG.debug("jrc-server response:" + content);
        CloseUtil.close(closeableResponse);
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

    private void init(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        loadRemoteData();
                    } catch (IOException e) {
                        e.printStackTrace();
                        LOG.error("request jrc-server fail ,reason:" + e.getMessage() + " jrc-server address:" + MetaConfig.getServerUrl());
                    }

                    try {
                        Thread.sleep(MetaConfig.getRequestConfigTime());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
