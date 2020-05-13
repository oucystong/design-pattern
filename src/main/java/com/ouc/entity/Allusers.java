package com.ouc.entity;

import org.apache.log4j.Logger;

import java.util.Date;

public class Allusers {
    private static final Logger logger = Logger.getLogger(Allusers.class);

    private Integer id;
	private String username;
	private String pwd;
	private String cx;
    private String addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

	public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

	public String getCx() {
        return cx;
    }

    public void setCx(String cx) {
        this.cx = cx == null ? null : cx.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }

    public void outputToLogFile(){
        logger.info(new Date() + "用户Id："+getId()+"用户名称："+getUsername());
    }
}

