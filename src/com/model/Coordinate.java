package com.model;

import com.alibaba.fastjson.annotation.JSONField;


public class Coordinate {
    //添加注解，指定json串中key的名称
    @JSONField(name = "latitude")
    private float Latitude;
    @JSONField(name = "longitude")
    private float Longitude;
    @JSONField(name = "time")
    private String Time;

    public Coordinate(float latitude, float longitude, String time) {
        Latitude = latitude;
        Longitude = longitude;
        Time = time;
    }

    public Coordinate() {
    }

    public float getLatitude() {
        return Latitude;
    }

    public void setLatitude(float latitude) {
        Latitude = latitude;
    }

    public float getLongitude() {
        return Longitude;
    }

    public void setLongitude(float longitude) {
        Longitude = longitude;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
