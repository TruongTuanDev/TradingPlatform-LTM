package model;

import com.google.gson.annotations.SerializedName;

public class Quote {
    @SerializedName("USD")
    private USD usd;

    public USD getUsd() {
        return usd;
    }

    public void setUsd(USD usd) {
        this.usd = usd;
    }
}
