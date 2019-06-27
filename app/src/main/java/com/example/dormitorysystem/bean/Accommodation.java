package com.example.dormitorysystem.bean;

public class Accommodation {
    private String dm_number;//宿舍号  dormitory ----dm
    private String dm_type;//男或女宿舍
    private String dm_accommodation;//入住情况
    private String adt_number;//入住人数    Accommodation ----  adt
    private String dm_address;//宿舍楼地址
    private String nation_1;//入住人的民族
    private String nation_2;
    private String nation_3;
    private String nation_4;
    private String nation_5;
    private String nation_6;
    private boolean xuanzhong;

    public Accommodation(String dm_number, String dm_type, String dm_accommodation, String adt_number, String dm_address,
                         String nation_1, String nation_2, String nation_3, String nation_4
                          , String nation_5, String nation_6,boolean xuanzhong) {
        this.dm_number =dm_number;
        this.dm_type =dm_type;
        this.dm_accommodation =dm_accommodation;
        this.adt_number = adt_number;
        this.dm_address =dm_address;
        this.nation_1 =nation_1;
        this.nation_2 =nation_2;
        this.nation_3 =nation_3;
        this.nation_4 =nation_4;
        this.nation_5 =nation_5;
        this.nation_6 =nation_6;
        this.xuanzhong = xuanzhong;
    }

    public boolean isxuanzhong() {
        return xuanzhong;
    }

    public void setChecked(boolean xuanzhong) {
        this.xuanzhong = xuanzhong;
    }

    public String getDm_number() {
        return dm_number;
    }

    public void setDm_number(String dm_number) {
        this.dm_number = dm_number;
    }

    public String getDm_type() {
        return dm_type;
    }

    public void setDm_type(String dm_type) {
        this.dm_type = dm_type;
    }

    public String getDm_accommodation() {
        return dm_accommodation;
    }

    public void setDm_accommodation(String dm_accommodation) {
        this.dm_accommodation = dm_accommodation;
    }

    public String getAdt_number() {
        return adt_number;
    }

    public void setAdt_number(String adt_number) {
        this.adt_number = adt_number;
    }

    public String getDm_address() {
        return dm_address;
    }

    public void setDm_address(String dm_address) {
        this.dm_address = dm_address;
    }

    public String getNation_1() {
        return nation_1;
    }

    public void setNation_1(String nation_1) {
        this.nation_1 = nation_1;
    }

    public String getNation_2() {
        return nation_2;
    }

    public void setNation_2(String nation_2) {
        this.nation_2 = nation_2;
    }

    public String getNation_3() {
        return nation_3;
    }

    public void setNation_3(String nation_3) {
        this.nation_3 = nation_3;
    }

    public String getNation_4() {
        return nation_4;
    }

    public void setNation_4(String nation_4) {
        this.nation_4 = nation_4;
    }

    public String getNation_5() {
        return nation_5;
    }

    public void setNation_5(String nation_5) {
        this.nation_5 = nation_5;
    }

    public String getNation_6() {
        return nation_6;
    }

    public void setNation_6(String nation_6) {
        this.nation_6 = nation_6;
    }
}
