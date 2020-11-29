package com.model;

public class heatMap {
    private double lng;
    private double lat;
    private int cnt;

    public heatMap(double lng, double lat, int cnt) {
        this.lng = lng;
        this.lat = lat;
        this.cnt = cnt;
    }

    public heatMap() {
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

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
