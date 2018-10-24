package com.cheng.simplemvp.base;


import com.cheng.simplemvplibrary.BaseMvpFragment;
import com.cheng.simplemvplibrary.BasePresenter;
import com.cheng.simplemvplibrary.BaseModel;
import com.cheng.simplemvplibrary.BaseView;

public abstract class BaseFragment<M extends BaseModel, V extends BaseView, P extends BasePresenter> extends BaseMvpFragment<M, V, P> {
}
