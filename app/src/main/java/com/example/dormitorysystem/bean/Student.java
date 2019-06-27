package com.example.dormitorysystem.bean;

public class Student {
    private String stu_name;//姓名
    private String stu_sex;//性别
    private String stu_num;//学号
    private String stu_bornDate;//出生日期
    private String stu_nation;//名族
    private String stu_grade;//年级
    private String stu_college;  //学院
    private String stu_class;//班级
    private String stu_dromSituation;//住宿情况
    private String stu_dormAddress;//寝室地址
    private String bed_num;//床位编号
    boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    public String getBed_num() {
        return bed_num;
    }

    public void setBed_num(String bed_num) {
        this.bed_num = bed_num;
    }

    public Student(String bed_num, String stu_nation, String stu_name,  String stu_num, String stu_class ){
        this.bed_num = bed_num;
        this.stu_nation = stu_nation;
        this.stu_name = stu_name;
        this.stu_num = stu_num;
        this.stu_class = stu_class;
    }
    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_sex() {
        return stu_sex;
    }

    public void setStu_sex(String stu_sex) {
        this.stu_sex = stu_sex;
    }

    public String getStu_num() {
        return stu_num;
    }

    public void setStu_num(String stu_num) {
        this.stu_num = stu_num;
    }

    public String getStu_bornDate() {
        return stu_bornDate;
    }

    public void setStu_bornDate(String stu_bornDate) {
        this.stu_bornDate = stu_bornDate;
    }

    public String getStu_nation() {
        return stu_nation;
    }

    public void setStu_nation(String stu_nation) {
        this.stu_nation = stu_nation;
    }

    public String getStu_grade() {
        return stu_grade;
    }

    public void setStu_grade(String stu_grade) {
        this.stu_grade = stu_grade;
    }

    public String getStu_college() {
        return stu_college;
    }

    public void setStu_college(String stu_college) {
        this.stu_college = stu_college;
    }

    public String getStu_class() {
        return stu_class;
    }

    public void setStu_class(String stu_class) {
        this.stu_class = stu_class;
    }

    public String getStu_dromSituation() {
        return stu_dromSituation;
    }

    public void setStu_dromSituation(String stu_dromSituation) {
        this.stu_dromSituation = stu_dromSituation;
    }

    public String getStu_dormAddress() {
        return stu_dormAddress;
    }

    public void setStu_dormAddress(String stu_dormAddress) {
        this.stu_dormAddress = stu_dormAddress;
    }
}
