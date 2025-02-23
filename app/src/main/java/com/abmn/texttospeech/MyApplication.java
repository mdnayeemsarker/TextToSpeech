package com.abmn.texttospeech;

import android.app.Application;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Config.setVoiceSpeed("slow");
        Config.setVoiceGender("male");
    }
}
