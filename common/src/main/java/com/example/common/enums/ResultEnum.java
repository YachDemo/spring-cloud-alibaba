package com.example.common.enums;

/**
 * 返回值枚舉類
 *
 * @author YanCh
 * Create by 2019-12-30 15:34
 **/
public enum ResultEnum {

    //  YanCh 1001  --> 1100
    BEAD_REQUEST("400", "參數不合法！"),
    TOKEN_LEGITIMATE_ERROR("401", ""),
    OFFSITE_LOGIN_ERROR("401", "賬戶在別處登錄！"),
    FREEZE_ERROR("401", "賬戶被凍結！"),
    EXP_TOKEN_ERROR("401", "登錄信息過期！"),
    LOGOUTING_ERROR("401", "賬戶注销審核中！"),
    BAD_GATEWAY("502", "請求方式錯誤，請檢查！"),
    LOCK_IP("503", "請不要頻繁請求！"),
    SUCCESS("0000", "操作成功！"),

    ERROR("9999", "服務器開小差，請稍後再試！");

    private String code;

    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}



