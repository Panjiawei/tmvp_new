package com.cheng.simplemvp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cheng.simplemvp.MainBaseModel;
import com.cheng.simplemvp.MainBaseView;
import com.cheng.simplemvp.activity.model.MainBaseModelImpl;
import com.cheng.simplemvp.base.BaseActivity;
import com.cheng.simplemvp.activity.presenter.MainPresenter;
import com.cheng.simplemvp.R;

public class MainActivity extends BaseActivity<MainBaseModel, MainBaseView, MainPresenter> implements MainBaseView {
    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvData = findViewById(R.id.tv_data);
        Button btnFirst = findViewById(R.id.btn_first);
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
        init();
    }


    @Override
    public MainBaseModel createModel() {
        return new MainBaseModelImpl();
    }

    @Override
    public MainBaseView createView() {
        return this;
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    private void init() {
        if (presenter != null) {
            presenter.getData();
        }
    }

    @Override
    public void setData(String str) {
        tvData.setText(str);
    }

    @Override
    public void showToast(String info) {

    }

    @Override
    public void showProgress() {

    }
}
