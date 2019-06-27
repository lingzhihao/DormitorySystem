package com.example.dormitorysystem.bean;

public class LoginOkGo extends ErrorModel {


    /**
     * access_token : eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NjE0MDM4MzcsInVzZXJfbmFtZSI6IntcInJlYWxuYW1lXCI6XCLotoXkurpcIixcInJvbGVJZHNcIjpbXSxcInRlbHBob25lXCI6XCJcIixcInVzZXJpZFwiOlwiMVwiLFwidXNlcm5hbWVcIjpcImFkbWluXCJ9IiwianRpIjoiYmViNWY1OTEtMzVlMS00OTBhLTk2NDEtMTZlNzVjMmM4ODY4IiwiY2xpZW50X2lkIjoienlmcmFtZXdvcmstY29yZS1zeXN0ZW0tdWFhLXNlcnZpY2UiLCJzY29wZSI6WyJiYXIiLCJyZWFkIiwid3JpdGUiLCJzZXJ2aWNlIl19.IDbJ7EQ-CJjo86naCCrtoZQI4fJrGYOAUIE4a1j9GJoPAQw9NJPuO_cp_cqSlmofQ5p2VCr2Kuxwbh2VCqdhCNZUG2SeulMT9TLEf72sQRofS0ehRPmAGjrXhwkQSTQcBIIHW9prhWdSP3p5ICzY0RtTKs6ap6HxBg5BRvwBTY3alFoMZOunicKQptALyLBbp22fcg1r5wHmsRLX5f9wAZvPl_KHmco6kSuMyzDrDCta4FRrTL8lnOF-t9UQ2wVhF0N7SiW0ZbKLfS4KNuqNWOuotiNDtT6Jri95a4kUCvXHaredIKg7URiAZ7pCDV4BBEm_6wXZ-DUO9kPOMQ4O-Q
     * token_type : bearer
     * refresh_token : eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NjE0MDM4MzcsInVzZXJfbmFtZSI6IntcInJlYWxuYW1lXCI6XCLotoXkurpcIixcInJvbGVJZHNcIjpbXSxcInRlbHBob25lXCI6XCJcIixcInVzZXJpZFwiOlwiMVwiLFwidXNlcm5hbWVcIjpcImFkbWluXCJ9IiwianRpIjoiMjI2NDJlZTItZjZhMy00NTBhLTk0MDYtMzBkNjgyNTEwM2MxIiwiY2xpZW50X2lkIjoienlmcmFtZXdvcmstY29yZS1zeXN0ZW0tdWFhLXNlcnZpY2UiLCJzY29wZSI6WyJiYXIiLCJyZWFkIiwid3JpdGUiLCJzZXJ2aWNlIl0sImF0aSI6ImJlYjVmNTkxLTM1ZTEtNDkwYS05NjQxLTE2ZTc1YzJjODg2OCJ9.TVzoTRhIpxP5XX498eA7zcKrfpdJ6zCZ2rhMByPG27EzdSXyKSGUYJF5U0xK-jwmM_RSzXwpBuwabIuwA6Qn-71nS047s1sOrB_Rzsz1yLNzcRjablrfnRwNSh90XL0M5BwCKj_F7I7rwZ1BAWPqz2QksUGouyU8v8i4lgcArLUbyl07ugLJr4SVnv2iZvLS_NiJOUmkfs9XsX24cQJT2WmUbydIjWeTJbgzMlFRl-wI78DcHY7rasXVodnTzssPfTGFEGyepsqk_zhzcBSp4MeE1EUTVs2z1U-bboPwOa24DVVLbZ9YxYDM-5G8tkWc1QVaxVqe9asPMravUIf_Kw
     * expires_in : 35999
     * scope : bar read write service
     * jti : beb5f591-35e1-490a-9641-16e75c2c8868
     */

    private String access_token;
    private String token_type;
    private String refresh_token;
    private int expires_in;
    private String scope;
    private String jti;


    /**
     * errcode : 400
     * errmsg : 账号不存在!
     * path : /oauth/token
     * timestamp : 1561368164605
     */

//    private String errcode;
//    private String errmsg;
//    private String path;
//    private String timestamp;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }


//    public String getErrcode() {
//        return errcode;
//    }
//
//    public void setErrcode(String errcode) {
//        this.errcode = errcode;
//    }
//
//    public String getErrmsg() {
//        return errmsg;
//    }
//
//    public void setErrmsg(String errmsg) {
//        this.errmsg = errmsg;
//    }
//
//    public String getPath() {
//        return path;
//    }
//
//    public void setPath(String path) {
//        this.path = path;
//    }
//
//    public String getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(String timestamp) {
//        this.timestamp = timestamp;
//    }
}
