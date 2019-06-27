package com.example.dormitorysystem.bean;

public class SelectionClass {
    private String class_name;
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public SelectionClass(String class_name,boolean checked){
        this.class_name=class_name;
        this.checked=checked;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
