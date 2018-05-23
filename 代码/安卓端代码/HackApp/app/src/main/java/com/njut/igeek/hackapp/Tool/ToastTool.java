package com.njut.igeek.hackapp.Tool;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;


import com.njut.igeek.hackapp.MyApplication;

import java.util.List;

/**
 * Created by ritchiehuang on 5/6/17.
 */

public class ToastTool {
    private static ToastTool toastTool;
    private static Toast mToast;
    private static Context mContext;

    private ToastTool() {
    }

    ;

    /**
     * 初始化
     *
     * @param context
     * @return
     */
    public static void init(Context context) {
        if (null == toastTool) {
            toastTool = new ToastTool();
        }
        mContext = context;
    }


    /**
     * 显示，方便一些不方便获取Context的地方调用。但调用此方法前，必须先初始化init(context)
     *
     * @param text
     */
    public static void showToast(String text) {
        showToast(text, false);
    }

    public static void showToast(int resId) {
        if (mContext == null) {
            return;
        }
        String text = mContext.getResources().getString(resId);
        if (!TextUtils.isEmpty(text)) {
            showToast(text, false);
        }
    }

    public static void showToast(int resId, boolean onlyShowInForeground) {
        if (mContext == null) {
            return;
        }
        String text = mContext.getResources().getString(resId);
        if (!TextUtils.isEmpty(text)) {
            showToast(text, onlyShowInForeground);
        }
    }

    /**
     * 显示Toast，方便一些不方便获取Context的地方调用。但调用此方法前，必须先初始化init(context)
     *
     * @param text                 显示的内容
     * @param onlyShowInForeground 是否仅当app在前台时显示
     */
    public static void showToast(String text, boolean onlyShowInForeground) {
        if (mContext != null) {
            if (onlyShowInForeground && !isAppForeground(mContext)) {
                return;
            }
            if (mToast == null) {
                mToast = Toast.makeText(mContext, text, Toast.LENGTH_SHORT);
            } else {
                mToast.cancel();
                mToast.setText(text);
                mToast.setDuration(Toast.LENGTH_SHORT);
            }
            mToast.show();
        }
    }

    ///////////////////////以下不需初始化，可直接调用显示

    public static void showToast(Context context, String text) {
        showToast(context, text, false);
    }

    public static void showToast(Context context, int resId) {
        String text = context.getResources().getString(resId);
        if (!TextUtils.isEmpty(text)) {
            showToast(context, text, false);
        }
    }

    public static void showToast(Context context, int resId, boolean onlyShowInForeground) {
        String text = context.getResources().getString(resId);
        if (!TextUtils.isEmpty(text)) {
            showToast(context, text, onlyShowInForeground);
        }
    }

    /**
     * 显示Toast
     *
     * @param context
     * @param text                 显示的内容
     * @param onlyShowInForeground 是否仅当app在前台时显示
     */
    public static void showToast(Context context, String text, boolean onlyShowInForeground) {
        if (onlyShowInForeground && !isAppForeground(context)) {
            return;
        }
        init(context);
        if (mToast == null) {
            mToast = Toast.makeText(mContext, text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void showAppToast(String text) {
        showToast(MyApplication.getInstance(), text, false);
    }

    public static void showAppToast(int resId) {
        String text = MyApplication.getInstance().getResources().getString(resId);
        if (!TextUtils.isEmpty(text)) {
            showToast(MyApplication.getInstance(), text, false);
        }
    }


    /**
     * 取消显示
     */
    public static void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

    /**
     * 判断当前应用是否在前台
     *
     * @param context
     * @return true 前台，false 后台
     */
    private static boolean isAppForeground(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(context.getPackageName())) {
                if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}