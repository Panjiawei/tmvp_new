package com.cheng.simplemvp.base;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cheng.simplemvp.app.App;
import com.cheng.simplemvp.utils.ToastUtils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by codeest on 16/8/11.
 * 无MVP的activity基类
 */

public abstract class SimpleActivity extends AppCompatActivity {


    protected Activity mContext;
  //  private Unbinder mUnBinder;


    protected HashMap map = new HashMap();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
      //  mUnBinder = ButterKnife.bind(this);
        mContext = this;

        onViewCreated();
        initEventAndData();
        setMap();

    }



    protected void showToast(String content) {
        if (!TextUtils.isEmpty(content))
            ToastUtils.getInstance(this).showToast(this, content);
    }

    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                onBackPressedSupport();
            }
        });
    }

    protected void onViewCreated() {

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

        //mUnBinder.unbind();


    }

    protected abstract int getLayout();

    protected abstract void initEventAndData();


    private void setMap() {

    }
}
