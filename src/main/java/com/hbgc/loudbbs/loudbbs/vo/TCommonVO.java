package com.hbgc.loudbbs.loudbbs.vo;

import java.io.Serializable;

/**
 * 一个评论视图，里边包含评论信息，话题名称和评论人昵称。
 */
public class TCommonVO implements Serializable {
    /*t_common.coid,
        t_common.uid,
        t_common.tid,
        t_common.updatetime,
        t_common.maincommon,
        t_users.username,
        t_topic.topicname*/
    private int coid;
    private int uid;
    private int tid;
    private String updatetime;
    private String maincommon;
    private String username;
    private String topicname;


    public int getCoid() {
        return coid;
    }

    public void setCoid(int coid) {
        this.coid = coid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getMaincommon() {
        return maincommon;
    }

    public void setMaincommon(String maincommon) {
        this.maincommon = maincommon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }
}
