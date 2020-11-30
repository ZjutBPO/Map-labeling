package com.model;

public class UserData {
    private String timestamp;
    private String timestamp2;
    private String imsi;
    private double lng;
    private double lat;

    public UserData(String timestamp, String timestamp2, String imsi, double lng, double lat) {
        this.timestamp = timestamp;
        this.timestamp2 = timestamp2;
        this.imsi = imsi;
        this.lng = lng;
        this.lat = lat;
    }

    public UserData() {
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestamp2() {
        return timestamp2;
    }

    public void setTimestamp2(String timestamp2) {
        this.timestamp2 = timestamp2;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
