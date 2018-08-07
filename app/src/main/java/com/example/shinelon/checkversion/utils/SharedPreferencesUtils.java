package com.example.shinelon.checkversion.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;

import com.example.shinelon.checkversion.interfaces.Constant;

import java.util.Map;

/**
 * Created by Peng on 2017/8/2.
 */

public class SharedPreferencesUtils {
    public static String CONFIGNAME = "configname";
    public static String CONFIGID = "configid";
    public static String CONFIGCHANNEL = "configchannel";
    /**
     * 存放填过的版本
     */
    public static String NEWDATA = "newdata";


    /**
     * 存入某个key对应的value值
     *
     * @param context
     * @param key
     * @param value
     */
    public static void put(Context context, String type, String key, Object value) {
        SharedPreferences sp = context.getSharedPreferences(CONFIGNAME, Context.MODE_PRIVATE);
        SharedPreferences sp2 = context.getSharedPreferences(CONFIGID, Context.MODE_PRIVATE);
        SharedPreferences sp3 = context.getSharedPreferences(CONFIGCHANNEL, Context.MODE_PRIVATE);
        SharedPreferences sp4 = context.getSharedPreferences(NEWDATA, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        SharedPreferences.Editor edit2 = sp2.edit();
        SharedPreferences.Editor edit3 = sp3.edit();
        SharedPreferences.Editor edit4 = sp4.edit();
        if (value instanceof String) {

            if (type.equals(Constant.VN)) {
                edit.putString(key, (String) value);
            } else if (type.equals(Constant.VI)) {
                edit2.putString(key, (String) value);
            } else if (type.equals(Constant.CL)) {
                edit3.putString(key, (String) value);
            } else {
                edit4.putString(key, (String) value);
            }
        } else if (value instanceof Integer) {
            edit.putInt(key, (Integer) value);
        } else if (value instanceof Boolean) {
            edit.putBoolean(key, (Boolean) value);
        } else if (value instanceof Float) {
            edit.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            edit.putLong(key, (Long) value);
        }
        SharedPreferencesCompat.EditorCompat.getInstance().apply(edit);
        SharedPreferencesCompat.EditorCompat.getInstance().apply(edit2);
        SharedPreferencesCompat.EditorCompat.getInstance().apply(edit3);
        SharedPreferencesCompat.EditorCompat.getInstance().apply(edit4);
    }

    /**
     * 得到某个key对应的值
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static Object get(Context context, String type, String key, Object defValue) {
        SharedPreferences sp = context.getSharedPreferences(CONFIGNAME, Context.MODE_PRIVATE);
        SharedPreferences sp2 = context.getSharedPreferences(CONFIGID, Context.MODE_PRIVATE);
        SharedPreferences sp4 = context.getSharedPreferences(NEWDATA, Context.MODE_PRIVATE);
        if (defValue instanceof String) {
            if (type.equals(Constant.VN)) {
                return sp.getString(key, (String) defValue);
            } else if (type.equals(Constant.VI)) {
                return sp2.getString(key, (String) defValue);
            } else {
                return sp4.getString(key, (String) defValue);
            }
        } else if (defValue instanceof Integer) {
            return sp.getInt(key, (Integer) defValue);
        } else if (defValue instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defValue);
        } else if (defValue instanceof Float) {
            return sp.getFloat(key, (Float) defValue);
        } else if (defValue instanceof Long) {
            return sp.getLong(key, (Long) defValue);
        }
        return null;
    }

    /**
     * 返回所有数据
     *
     * @param context
     * @return
     */
    public static Map<String, ?> getAll(Context context, String type) {
        SharedPreferences sp = context.getSharedPreferences(CONFIGNAME, Context.MODE_PRIVATE);
        SharedPreferences sp2 = context.getSharedPreferences(CONFIGID, Context.MODE_PRIVATE);
        SharedPreferences sp3 = context.getSharedPreferences(CONFIGCHANNEL, Context.MODE_PRIVATE);
        if (type.equals(Constant.VN)) {
            return sp.getAll();
        } else if (type.equals(Constant.VI)) {
            return sp2.getAll();
        } else {
            return sp3.getAll();
        }
    }


    /**
     * 移除某个key值已经对应的值
     *
     * @param context
     * @param key
     */
    public static void remove(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(CONFIGNAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.remove(key);
        SharedPreferencesCompat.EditorCompat.getInstance().apply(edit);
    }

    /**
     * 清除所有内容
     *
     * @param context
     */
    public static void clear(Context context) {
        SharedPreferences sp = context.getSharedPreferences(CONFIGNAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.clear();
        SharedPreferencesCompat.EditorCompat.getInstance().apply(edit);
    }


}
