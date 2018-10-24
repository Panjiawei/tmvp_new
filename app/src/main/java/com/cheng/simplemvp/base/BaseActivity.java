package com.cheng.simplemvp.base;


import com.cheng.simplemvplibrary.BaseModel;
import com.cheng.simplemvplibrary.BaseMvpActivity;
import com.cheng.simplemvplibrary.BasePresenter;
import com.cheng.simplemvplibrary.BaseView;

public abstract class BaseActivity<M extends BaseModel, V extends BaseView, P extends BasePresenter> extends BaseMvpActivity<M, V, P> {

}
