package com.fluent.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferencesUtil {

    public static final String USER_NAME = "user_name";
    public static final String USER_EMAIL = "user_email";
    public static final String USER_ID = "user_id";
    public static final String HAS_LOGIN = "has_login";

    private static void setBooleanPreferences(Context context, String key, boolean value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    private static boolean getBooleanPreferences(Context context, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key, false);
    }

    private static void setStringPreferences(Context context, String key, String value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    private static String getStringPreferences(Context context, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, "");
    }

    private static void setIntPreferences(Context context, String key, int value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    private static int getIntPreferences(Context context, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt(key, 0);
    }

    public static void setUserName(Context context, String value) {
        setStringPreferences(context, USER_NAME, value);
    }

    public static String getUserName(Context context) {
        return getStringPreferences(context, USER_NAME);
    }

    public static void setUserEmail(Context context, String value) {
        setStringPreferences(context, USER_EMAIL, value);
    }

    public static String getUserEmail(Context context) {
        return getStringPreferences(context, USER_EMAIL);
    }


    public static void setHasLogin(Context context, boolean value) {
        setBooleanPreferences(context, HAS_LOGIN, value);
    }

    public static boolean getHasLogin(Context context) {
        return getBooleanPreferences(context, HAS_LOGIN);
    }

    public static void setUserId(Context context, int value) {
        setIntPreferences(context, USER_ID, value);
    }

    public static int getUserId(Context context) {
        return getIntPreferences(context, USER_ID);
    }

}
