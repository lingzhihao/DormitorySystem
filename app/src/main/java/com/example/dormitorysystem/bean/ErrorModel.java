package com.example.dormitorysystem.bean;

import com.google.gson.annotations.SerializedName;

public class ErrorModel {


    /**
     * errcode : 400
     * errmsg : 账号不存在!
     * path : /oauth/token
     * timestamp : 1561425876473
     */

    @SerializedName(value = "errcode",alternate = "errCode")
    public String errcode;
    @SerializedName(value = "errmsg",alternate = "errMsg")
    public String errmsg;
    public String path;
    public String timestamp;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
