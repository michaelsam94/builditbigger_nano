package com.udacity.gradle.builditbigger;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by micky on 30-Apr-17.
 */

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
