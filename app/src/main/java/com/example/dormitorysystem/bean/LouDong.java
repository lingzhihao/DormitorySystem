package com.example.dormitorysystem.bean;

public class LouDong {
    private String loudong_name;
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public LouDong(String loudong_name,boolean checked){
        this.loudong_name=loudong_name;
        this.checked = checked;
    }

    public String getLoudong_name() {
        return loudong_name;
    }

    public void setLoudong_name(String loudong_name) {
        this.loudong_name = loudong_name;
    }
}
