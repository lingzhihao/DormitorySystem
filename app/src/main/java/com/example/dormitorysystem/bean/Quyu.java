package com.example.dormitorysystem.bean;

public class Quyu {
    private String quyu_name;
    private boolean checked;



    public Quyu(String quyu_name,boolean checked){
        this.quyu_name=quyu_name;
        this.checked = checked;

    }

    public String getQuyu_name() {
        return quyu_name;
    }

    public void setQuyu_name(String quyu_name) {
        this.quyu_name = quyu_name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
