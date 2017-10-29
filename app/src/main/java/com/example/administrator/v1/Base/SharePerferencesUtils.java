package com.example.administrator.v1.Base;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/10/21.
 */

public class SharePerferencesUtils {
  private static SharedPreferences sharedPreferences = null;
    final static String PERFERENCES_NAME="Q";

    public static void init(Context context){
        if(sharedPreferences==null){
            sharedPreferences = context.getSharedPreferences(PERFERENCES_NAME,Context.MODE_PRIVATE);
        }

    }
    public static boolean put(String key,String value){
        return sharedPreferences.edit().putString(key,value).commit();
    }
    public static boolean put(String key,boolean value){
        return sharedPreferences.edit().putBoolean(key,value).commit();
    }
    public static boolean put(String key,int value){
        return sharedPreferences.edit().putInt(key,value).commit();
    }

    public static String getString(String key){
        return sharedPreferences.getString(key,"");
    }
    public static boolean getBoolean(String key){
        return sharedPreferences.getBoolean(key,false);
    }
    public static int getInt(String key){
        return sharedPreferences.getInt(key,-1);
    }
}
