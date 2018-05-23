package com.njut.igeek.hackapp.Https;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.njut.igeek.hackapp.View.LoadDialog;


public class ProgressDialogHandler extends Handler {

    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;

    private Context context;

    public ProgressDialogHandler(Context context) {
        super();
        this.context = context;
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
                LoadDialog.show(context);
                break;
            case DISMISS_PROGRESS_DIALOG:
                LoadDialog.dismiss(context);
                break;
        }
    }
}