package com.cheng.simplemvp.fragment;

import com.cheng.simplemvplibrary.BaseModel;

public interface BlackBaseModel extends BaseModel {
    String getDataFromHWW();

    void stopRequest();
}
