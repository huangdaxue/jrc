package com.xiaojiezhu.jrc.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiaojie.zhu
 */
public class Version implements Serializable {

    private int id;

    private String version;

    private String profile;

    private String content;

    /**
     * request number
     */
    private int requestNumber;

    private Date createTime;

    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Version{" +
                "id=" + id +
                ", version='" + version + '\'' +
                ", profile='" + profile + '\'' +
                ", content='" + content + '\'' +
                ", requestNumber=" + requestNumber +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
