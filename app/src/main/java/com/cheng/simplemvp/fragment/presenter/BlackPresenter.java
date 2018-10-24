package com.cheng.simplemvp.fragment.presenter;


import android.util.Log;

import com.cheng.simplemvp.fragment.BlackBaseModel;
import com.cheng.simplemvp.fragment.BlackBaseView;
import com.cheng.simplemvplibrary.BasePresenter;

public class BlackPresenter extends BasePresenter<BlackBaseModel, BlackBaseView> {
    public void getData() {
        String dataFromNet = null;
        if (model != null) {
            dataFromNet = model.getDataFromHWW();
        }
        if (getView() != null) {
            getView().setTextData(dataFromNet);
        }
    }

    @Override
    protected void onViewDestroy() {
        Log.i("view-uninstall", "SecondActivity finished");
        if (model != null) {
            model.stopRequest();
        }
    }

}
