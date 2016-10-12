package com.liuwan.customdialog.widget;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by liuwan on 2016/10/12.
 */
public class CustomDialog extends Dialog {

    private static int default_width = 160; // 默认宽度
    private static int default_height = 120; // 默认高度

    public CustomDialog(Context context, View layout, int style) {
        this(context, default_width, default_height, layout, style);
    }

    public CustomDialog(Context context, double widthScale, double heightScale, View layout, int style) {
        super(context, style);
        setContentView(layout);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        int windowWidth = outMetrics.widthPixels;
        int windowHeight = outMetrics.heightPixels;

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = (int) (windowWidth * widthScale); // 宽度设置为屏幕的一定比例大小
        if (heightScale == 0) {
            params.gravity = Gravity.CENTER;
        } else {
            params.gravity = Gravity.TOP;
            params.y = (int) (windowHeight * heightScale); // 距离顶端高度设置为屏幕的一定比例大小
        }
        getWindow().setAttributes(params);
    }

}