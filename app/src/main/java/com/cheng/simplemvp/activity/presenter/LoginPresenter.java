package com.cheng.simplemvp.activity.presenter;

import android.util.Log;

import com.cheng.simplemvp.activity.contract.LoginContract;

import com.cheng.simplemvp.activity.model.LoginModel;
import com.cheng.simplemvp.model.BaseJson;
import com.google.gson.Gson;

/**
 * Created by andriod_pan on 2018/7/11.
 */

public class LoginPresenter extends LoginContract.Presenter {

    @Override
    public void login(String ph) {

        model.login(ph, new LoginModel.OnLoginResultListener() {
            @Override
            public void loginSuccess(String s) {
                BaseJson baseJson = new Gson().fromJson(s, BaseJson.class);
                Log.e("String", baseJson.toString());
                Log.e("String", s);

                if (baseJson.code == 200 || baseJson.code == 601) {
                    getView().showMsg("登陆成功");
                    Log.e("showMsg", baseJson.toString());
                    getView().loginSuccess();
                } else {
                    Log.e("showMsg", baseJson.toString());
                    getView().showMsg("登陆失败");
                }
            }

            @Override
            public void loginFailure() {
                getView().showMsg("登陆失败");
            }
        });


    }

    @Override
    protected void onViewDestroy() {

    }
}
