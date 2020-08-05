package com.smartyang.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefsManager {
    private static final String KEY_HAS_VALIDATED_CODE = "is_code_validated";
    private static SharedPreferences sharedPreferences;
    private static SharedPrefsManager mInstance;
    private final String SHARED_PREFS_NAME = "smart_young_prefs";
    private static final String TAG = "SharedPrefsManager";

    private SharedPrefsManager(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized SharedPrefsManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefsManager(context);
        }
        return mInstance;
    }

    /*Check if user has validated code*/
    public boolean hasValidatedCode() {
        return sharedPreferences.getBoolean(KEY_HAS_VALIDATED_CODE, false);
    }

    /*Set user has validated code to true/false*/
    public void setHasValidatedCode(boolean hasValidatedCode) {
        sharedPreferences.edit().putBoolean(KEY_HAS_VALIDATED_CODE, hasValidatedCode).apply();
    }
}
