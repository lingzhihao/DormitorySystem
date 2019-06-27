package com.example.dormitorysystem.bean;

public class StudentDetails {
    private String left_name;
    private String right_name;

    public StudentDetails(String left_name, String right_name){
        this.left_name=left_name;
        this.right_name=right_name;

    }
    public String getLeft_name() {
        return left_name;
    }

    public void setLeft_name(String left_name) {
        this.left_name = left_name;
    }

    public String getRight_name() {
        return right_name;
    }

    public void setRight_name(String right_name) {
        this.right_name = right_name;
    }
}
