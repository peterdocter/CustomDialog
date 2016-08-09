package com.along.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by L on 2016/7/1.
 */
public class CustomDialog extends Dialog {

    public CustomDialog(Context context) {
        super(context, R.style.myselfdialog);
        //通过LayoutParams可以自定义特有属性
        Window window = getWindow();
        //生成WindowManager的LayoutParams,Window没有LayoutParams
        WindowManager.LayoutParams params = window.getAttributes();
        //LayoutParams params = new WindowManager.LayoutParams(); new出的对象不作用于此Dialog,不起作用
        params.gravity = Gravity.CENTER;

    }


}
