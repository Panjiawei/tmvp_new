package com.cheng.simplemvp.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import java.lang.ref.WeakReference;

/**
 * Created by chenkefan on 17/3/14.
 */

public class ToastUtils {
    private   static String oldContent;
    private static Toast toast = null;

    private static  long firstTime = 0;
    private static long endTime = 0;

    private WeakReference<Context> contextWeakReference  = null;
    private static ToastUtils mInstance = null;

     public   void showToast(Context context, String content){
        if (toast == null){

            toast = Toast.makeText(context,content, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            firstTime = System.currentTimeMillis();
        }else{
            endTime = System.currentTimeMillis();
//            Log.e("toast_info",oldContent+","+content);
            if(content!=null&&content.equals(oldContent)){

                if(endTime-firstTime> Toast.LENGTH_LONG){
                    toast.show();
                }
            }else {
                oldContent = content;
                toast.setText(content);
                toast.show();
            }
        }
        firstTime = endTime;
    }
    public static ToastUtils getInstance(Context context){
        if(mInstance == null){
            synchronized (ToastUtils.class){
                if (mInstance == null){
                    mInstance = new ToastUtils(context);
                }
            }
        }
        return mInstance;
    }

    private ToastUtils(Context context){
        contextWeakReference = new WeakReference<Context>(context);
    }

}
