package com.cheng.simplemvp.fragment.model;


import android.util.Log;

import com.cheng.simplemvp.fragment.BlackBaseModel;

public class BlackBaseModelImpl implements BlackBaseModel {
    @Override
    public String getDataFromHWW() {
        return "data from net";
    }

    @Override
    public void stopRequest() {
        Log.i("model-stopped", "BlackBaseModelImpl stop request...");
    }
}
