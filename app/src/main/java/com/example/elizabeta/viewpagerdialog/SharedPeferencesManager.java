package com.example.elizabeta.viewpagerdialog;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPeferencesManager {

    private static SharedPeferencesManager yourPreference;
    private SharedPreferences sharedPreferences;

    public static SharedPeferencesManager getInstance(Context context) {
        if (yourPreference == null) {
            yourPreference = new SharedPeferencesManager(context);
        }
        return yourPreference;
    }
    private SharedPeferencesManager(Context context) {
        sharedPreferences = context.getSharedPreferences("YourCustomNamedPreference",Context.MODE_PRIVATE);
    }

    public void saveData(int num) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putInt("Data",num);
        prefsEditor.apply();
    }

    public int getData() {
        if (sharedPreferences!= null) {
            return sharedPreferences.getInt("Data", -1);
        }
        return -1;
    }


}
