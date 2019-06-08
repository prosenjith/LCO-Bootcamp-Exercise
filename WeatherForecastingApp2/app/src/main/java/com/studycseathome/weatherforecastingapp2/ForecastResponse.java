
package com.studycseathome.weatherforecastingapp2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForecastResponse {

    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Double message;
    @SerializedName("cnt")
    @Expose
    private Long cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<com.studycseathome.weatherforecastingapp2.List> list = null;
    @SerializedName("city")
    @Expose
    private City city;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public Long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }

    public java.util.List<com.studycseathome.weatherforecastingapp2.List> getList() {
        return list;
    }

    public void setList(java.util.List<com.studycseathome.weatherforecastingapp2.List> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
