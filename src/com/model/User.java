package com.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class User {
    //添加注解，指定json串中key的名称
    @JSONField(name = "path")
    private ArrayList<Coordinate> path;
    @JSONField(name = "imsi")
    private String imsi;

    public User(ArrayList<Coordinate> path, String imsi) {
        this.path = path;
        this.imsi = imsi;
    }

    public User() {
    }

    public ArrayList<Coordinate> getPath() {
        return path;
    }

    public void setPath(ArrayList<Coordinate> path) {
        this.path = path;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }
}
