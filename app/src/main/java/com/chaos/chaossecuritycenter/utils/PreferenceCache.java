package com.chaos.chaossecuritycenter.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.chaos.chaossecuritycenter.base.BaseApplication;


public class PreferenceCache {
    public static final String PF_TOKEN = "token"; // token
    public static final String PF_GUIDE_PAGE = "guide_page";
    public static final String PF_VERSION = "";
    public static final String PF_AUTO_LOGIN = "auton_login"; // 自动登录
    public static final String PF_PHONE_NUM = "phone_number"; // 自动登录
    public static final String PF_USERNAME = "username";// 保存上次登录的用户名
    public static final String PF_SKIP_LOGIN = "skip_login"; // 跳过登录环节
    public static final String PF_MOBILE_VERIFICATION_CODE = "mobile_verification_code"; // 手机验证码
    public static final String BANK_OPEN_FLG = "bank_open_flg"; // 登陆后是否跳出dialog提示银行开通账户
    public static final String GESTURE_FLG = "gesture_flg"; // 判断是否设置有手势密码
    public static final String GESTURE_TIME = "gesture_time"; // 手势密码输入错误超过5次时间
    public static final String ACCOUNT_EYE = "account_eye"; // 我的账户页面eye
    public static final String FINGEER_FLG="finger_flg";//存储指纹flg

    private static SharedPreferences getSharedPreferences() {
        BaseApplication app = (BaseApplication) BaseApplication.getAppContext();
        return app.getSharedPreferences("csyh", Context.MODE_PRIVATE);
    }
    public static void putToken(String token) {
        SharedPreferences pref = getSharedPreferences();

        Editor editor = pref.edit();
        editor.putString(PF_TOKEN, token);
        editor.commit();
    }

    public static String getToken() {
        return getSharedPreferences().getString(PF_TOKEN, "");
    }

    public static void putUsername(String username) {
        SharedPreferences pref = getSharedPreferences();

        Editor editor = pref.edit();
        editor.putString(PF_USERNAME, username);
        editor.commit();
    }

    public static String getUsername() {
        return getSharedPreferences().getString(PF_USERNAME, "");
    }

    public static boolean ifSkipLogin() {
        return getSharedPreferences().getBoolean(PF_SKIP_LOGIN, false);
    }

    public static void putIfSkipLogin(boolean skipLogin) {
        SharedPreferences pref = getSharedPreferences();

        Editor editor = pref.edit();
        editor.putBoolean(PF_SKIP_LOGIN, skipLogin);
        editor.commit();
    }

    public static void putAutoLogin(boolean isAutonLogin) {
        SharedPreferences pref = getSharedPreferences();

        Editor editor = pref.edit();
        editor.putBoolean(PF_AUTO_LOGIN, isAutonLogin);
        editor.commit();
    }

    public static boolean isAutoLogin() {
        return getSharedPreferences().getBoolean(PF_AUTO_LOGIN, true);
    }

    public static void putPhoneNum(String phoneNum) {
        SharedPreferences pref = getSharedPreferences();

        Editor editor = pref.edit();
        editor.putString(PF_PHONE_NUM, phoneNum);
        editor.commit();
    }

    public static String getPhoneNum() {
        return getSharedPreferences().getString(PF_PHONE_NUM, "");
    }

    public static void putGuidePage(boolean guidePage) {
        SharedPreferences pref = getSharedPreferences();

        Editor editor = pref.edit();
        editor.putBoolean(PF_GUIDE_PAGE, guidePage);
        editor.commit();
    }

    public static boolean getGuidePage() {
        return getSharedPreferences().getBoolean(PF_GUIDE_PAGE, true);
    }

    // 版本
    public static String getVersion() {
        return getSharedPreferences().getString(PF_VERSION, "");
    }

    public static void putVersion(String version) {
        SharedPreferences pref = getSharedPreferences();
        Editor editor = pref.edit();
        editor.putString(PF_VERSION, version);
        editor.commit();
    }

    public static void putVerificationCode(String mobileVerificationCode) {
        SharedPreferences pref = getSharedPreferences();

        Editor editor = pref.edit();
        editor.putString(PF_MOBILE_VERIFICATION_CODE, mobileVerificationCode);
        editor.commit();
    }

    public static String getVerificationCode() {
        return getSharedPreferences()
                .getString(PF_MOBILE_VERIFICATION_CODE, "");
    }


    public static void putBankOpenFlag(boolean flg) {
        SharedPreferences pref = getSharedPreferences();

        Editor editor = pref.edit();
        editor.putBoolean(BANK_OPEN_FLG, flg);
        editor.commit();
    }

    public static boolean getBankOpenFlag() {
        return getSharedPreferences()
                .getBoolean(BANK_OPEN_FLG, false);
    }

    public static void putLoginFlag(boolean flg) {
        SharedPreferences pref = getSharedPreferences();

        Editor editor = pref.edit();
        editor.putBoolean(BANK_OPEN_FLG, flg);
        editor.commit();
    }

    public static boolean getLoginFlag() {
        return getSharedPreferences()
                .getBoolean(BANK_OPEN_FLG, false);
    }

    public static void putGestureFlag(boolean flg) {
        SharedPreferences pref = getSharedPreferences();

        Editor editor = pref.edit();
        editor.putBoolean(GESTURE_FLG, flg);
        editor.commit();
    }

    public static boolean getGestureFlag() {
        return getSharedPreferences()
                .getBoolean(GESTURE_FLG, false);
    }

    public static void putFingerFlg(boolean flg){
        SharedPreferences pref = getSharedPreferences();

        Editor editor = pref.edit();
        editor.putBoolean(FINGEER_FLG, flg);
        editor.commit();
    }
    public static boolean getFingerFlg(){
        return getSharedPreferences()
                .getBoolean(FINGEER_FLG, false);
    }

    public static void putGestureTime(long time) {
        SharedPreferences pref = getSharedPreferences();
        Editor editor = pref.edit();
        editor.putLong(GESTURE_TIME, time);
        editor.commit();
    }

    public static long getGestureTime() {
        return getSharedPreferences()
                .getLong(GESTURE_TIME, 0);
    }

    public static void putAccountEye(boolean eyeFlg) {
        SharedPreferences pref = getSharedPreferences();
        Editor editor = pref.edit();
        editor.putBoolean(ACCOUNT_EYE, eyeFlg);
        editor.commit();
    }

    public static boolean getAccountEye() {
        return getSharedPreferences()
                .getBoolean(ACCOUNT_EYE, true);
    }

}
