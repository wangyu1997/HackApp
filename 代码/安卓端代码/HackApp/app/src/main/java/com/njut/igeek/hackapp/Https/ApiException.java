package com.njut.igeek.hackapp.Https;

import android.content.Context;
import android.content.Intent;

import com.njut.igeek.hackapp.MyApplication;
import com.njut.igeek.hackapp.Tool.ToastTool;


/**
 * Created by wangyu on 06/05/2017.
 */

public class ApiException extends Exception {

    public static final int EXPIRE_CODE = 101;
    public static final int ACCOUNT_DELETE_CODE = 102;
    public static final int NO_AUTHORITY_CODE = 103;
    public static final int ERROR_INFO = 400;
    private static String message;
    private String error;
    private int code;


    public ApiException(String error, int code) {
        this.error = error;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void ShowError() {
        ToastTool.showToast(MyApplication.getGlobalContext(), error);
        getApiExceptionMessage(this.code);
    }

    /**
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，在显示给用户
     *
     * @param code
     * @return
     */
    private void getApiExceptionMessage(int code) {
        switch (code) {
            case EXPIRE_CODE:
            case ACCOUNT_DELETE_CODE:
            case NO_AUTHORITY_CODE:
            case ERROR_INFO:

                break;
            default:
                break;
        }
    }

    /***重启整个APP*/
    public void restartAPP(Context context) {
        Intent i = context.getPackageManager()
                .getLaunchIntentForPackage(context.getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
