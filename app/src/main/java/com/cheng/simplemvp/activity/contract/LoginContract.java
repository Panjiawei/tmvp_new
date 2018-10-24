package com.cheng.simplemvp.activity.contract;

import com.cheng.simplemvp.activity.model.LoginModel;
import com.cheng.simplemvplibrary.BaseModel;
import com.cheng.simplemvplibrary.BasePresenter;
import com.cheng.simplemvplibrary.BaseView;


/**
 * Created by andriod_pan on 2018/7/11.
 */

public interface LoginContract {

    interface View extends BaseView {
         void loginSuccess();
         void showMsg(String msg);
    }

    interface Model extends BaseModel {
        void login(String username, LoginModel.OnLoginResultListener onLoginResultListener);

    }

    abstract class Presenter extends BasePresenter<Model, View> {

        public abstract void login(String username);
    }

}
