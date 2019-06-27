package com.example.dormitorysystem.bean;

public class BedDormModel {

    /**
     * bedCode : 1
     * bedId : 979
     * clazzName : 2016旅游管理（1）班
     * errCode :
     * errLog :
     * errMsg :
     * gradeName : 2016级
     * institutionName : 管理系
     * majorName : 旅游管理
     * nationName : 汉族
     * studentId : 10354
     * studentName : 加洋坦亏
     * studentNo : 201601010011
     */

    private String bedCode;
    private int bedId;
    private String clazzName;
    private String errCode;
    private String errLog;
    private String errMsg;
    private String gradeName;
    private String institutionName;
    private String majorName;
    private String nationName;
    private int studentId;
    private String studentName;
    private String studentNo;

    public String getBedCode() {
        return bedCode;
    }

    public void setBedCode(String bedCode) {
        this.bedCode = bedCode;
    }

    public int getBedId() {
        return bedId;
    }

    public void setBedId(int bedId) {
        this.bedId = bedId;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrLog() {
        return errLog;
    }

    public void setErrLog(String errLog) {
        this.errLog = errLog;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    @Override
    public String toString() {
        return "BedDormModel{" +
                "bedCode='" + bedCode + '\'' +
                ", bedId=" + bedId +
                ", clazzName='" + clazzName + '\'' +
                ", errCode='" + errCode + '\'' +
                ", errLog='" + errLog + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", gradeName='" + gradeName + '\'' +
                ", institutionName='" + institutionName + '\'' +
                ", majorName='" + majorName + '\'' +
                ", nationName='" + nationName + '\'' +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentNo='" + studentNo + '\'' +
                '}';
    }
}
