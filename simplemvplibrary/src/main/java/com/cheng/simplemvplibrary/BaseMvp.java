package com.cheng.simplemvplibrary;

public interface BaseMvp<M extends BaseModel, V extends BaseView, P extends BasePresenter> {
    M createModel();

    V createView();

    P createPresenter();
}
