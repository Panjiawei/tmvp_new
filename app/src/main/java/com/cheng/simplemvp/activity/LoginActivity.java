package com.cheng.simplemvp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cheng.simplemvp.MainBaseModel;
import com.cheng.simplemvp.MainBaseView;
import com.cheng.simplemvp.R;
import com.cheng.simplemvp.activity.contract.LoginContract;
import com.cheng.simplemvp.activity.model.LoginModel;
import com.cheng.simplemvp.activity.model.MainBaseModelImpl;
import com.cheng.simplemvp.activity.presenter.LoginPresenter;
import com.cheng.simplemvp.activity.presenter.MainPresenter;
import com.cheng.simplemvp.base.BaseActivity;

public class LoginActivity extends BaseActivity<LoginContract.Model, LoginContract.View, LoginContract.Presenter> implements LoginContract.View  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public LoginContract.Model createModel() {
        return new LoginModel();
    }

    @Override
    public LoginContract.View createView() {
        return this;
    }

    @Override
    public LoginContract.Presenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void showToast(String info) {

    }

    @Override
    public void showProgress() {

    }
}
