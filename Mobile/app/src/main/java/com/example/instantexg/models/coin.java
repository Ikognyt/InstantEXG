package com.example.instantexg.models;

import com.google.gson.annotations.SerializedName;

public class coin {

    @SerializedName("code")
    private String code;
    @SerializedName("name")
    private String name;
    @SerializedName("bid")
    private Double bid;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }
}
