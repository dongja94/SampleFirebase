package com.begentgroup.samplefirebase;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Administrator on 2016-09-19.
 */
public class PropertyManager {
    private static PropertyManager instance;
    public static PropertyManager getInstance() {
        if (instance == null) {
            instance =new PropertyManager();
        }
        return instance;
    }
    SharedPreferences mPrefs;
    SharedPreferences.Editor mEditor;
    private PropertyManager() {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext());
        mEditor = mPrefs.edit();
    }

    private static final String PROPERTY_REG_TOKEN = "regtoken";
    public void setRegistrationToken(String token) {
        mEditor.putString(PROPERTY_REG_TOKEN, token);
        mEditor.commit();
    }
    public String getRegistrationToken() {
        return mPrefs.getString(PROPERTY_REG_TOKEN, "");
    }
}
