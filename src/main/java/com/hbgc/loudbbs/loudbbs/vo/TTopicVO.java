package com.hbgc.loudbbs.loudbbs.vo;


import java.io.Serializable;

public class TTopicVO implements Serializable {
    /**
     * t_topic.topicname, t_topic.heat,
     * t_topic.mainbody, t_topic.createtime,
     * t_topic.updatetime, t_users.username,
     * t_topic.uid, t_topic.tid,
     * t_xxxx.cname
     */
    private Integer tid;
    private String topicname;
    private Integer heat;
    private String mainbody;
    private String htmlmainbody;
    private String createtime;
    private String updatetime;
    private String username;
    private Integer uid;
    private String cname;


    public String getHtmlmainbody() {
        return htmlmainbody;
    }

    public void setHtmlmainbody(String htmlmainbody) {
        this.htmlmainbody = htmlmainbody;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

    public Integer getHeat() {
        return heat;
    }

    public void setHeat(Integer heat) {
        this.heat = heat;
    }

    public String getMainbody() {
        return mainbody;
    }

    public void setMainbody(String mainbody) {
        this.mainbody = mainbody;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }


}
