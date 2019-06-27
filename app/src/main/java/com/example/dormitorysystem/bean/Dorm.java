package com.example.dormitorysystem.bean;

public class Dorm {
    private String dorm_num;
    private boolean mChecked;


    public boolean ismChecked() {
        return mChecked;
    }

    public void setmChecked(boolean mChecked) {
        this.mChecked = mChecked;
    }

    public Dorm(String dorm_num, boolean mChecked){
        this.dorm_num=dorm_num;
        this.mChecked=mChecked;
    }

    public String getDorm_num() {
        return dorm_num;
    }

    public void setDorm_num(String dorm_num) {
        this.dorm_num = dorm_num;
    }
}
