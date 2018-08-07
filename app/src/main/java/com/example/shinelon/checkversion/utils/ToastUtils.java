package com.example.shinelon.checkversion.utils;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by Peng on 2017/7/31.
 */

public class ToastUtils {
    public static void toast(Context mContext, String msg) {
        Toast toast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void toast2(Context mContext, String msg) {
        SpannableString ss = new SpannableString(msg);
        ss.setSpan(new ForegroundColorSpan(Color.RED), 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        Toast toast = new Toast(mContext);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setText(ss);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
