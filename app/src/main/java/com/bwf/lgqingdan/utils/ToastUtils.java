package com.bwf.lgqingdan.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/11/8.
 */

public class ToastUtils {
    private static Toast toast;

    public static final void show(Context context,Object obj){
        if(toast == null){
            toast = Toast.makeText(context.getApplicationContext(),obj+"",Toast.LENGTH_LONG);
        }else{
            toast.setText(obj+"");
        }
        toast.show();
    }
}
