package com.chuangshi.licai.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;

import com.chuangshi.licai.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;


/**
 * Created by Administrator on 2016/8/4.
 */
public class PublicUtils {

    /**
     * 倒计时
     *
     * @param view 控件
     * @param meg  倒计时结束需要展示的文字
     */
    public static void downTime(final TextView view, final String meg) {
        final Drawable background = view.getBackground();
        CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                view.setText(millisUntilFinished / 1000 + "秒后重新获取");
//                view.setBackgroundColor(Color.parseColor("#FFA4A4A4"));
                view.setEnabled(false);
            }

            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onFinish() {
                view.setEnabled(true);
//                view.setBackground(background);
                view.setText(meg);
            }
        };

        countDownTimer.start();
    }

    /**
     * 使用Picasso加载图片
     *
     * @param context
     * @param url       图片地址
     * @param imageView 加载图片控件
     */
    public static void setNetImage(Context context, String url, ImageView imageView) {
        Picasso.with(context).load(url)
                .placeholder(R.drawable.zheng_zai_jia_zai)//设置默认图片
                .error(R.drawable.zheng_zai_jia_zai)//设置默认图片
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)//只加载到本地，不加载到内存，防止oom
                .config(Bitmap.Config.RGB_565)
                .into(imageView);
    }

}
