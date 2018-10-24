package com.cheng.simplemvp.app;

import android.app.Application;
import android.content.Context;



/**
 * Created by andriod_pan on 2018/7/11.
 */

public class App extends Application {

    private static App app;

    public static Context getAppContext() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

    }

}
