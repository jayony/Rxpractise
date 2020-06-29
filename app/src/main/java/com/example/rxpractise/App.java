package com.example.rxpractise;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlowLog.setMinimumLoggingLevel(FlowLog.Level.E);//添加日志
        FlowManager.init(this);
    }
}
