package com.njut.igeek.hackapp.Https;

import android.content.Context;
import android.util.Log;


import com.njut.igeek.hackapp.Tool.NetworkUtil;
import com.njut.igeek.hackapp.R;
import com.njut.igeek.hackapp.Tool.ToastTool;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ProgressSubscriber<T> implements Observer<T> {

    private SubscriberListener mSubscriberListener;
    private ProgressDialogHandler mProgressDialogHandler;
    private boolean showProgessBar;
    private Context context;

    public ProgressSubscriber(SubscriberListener mSubscriberListener, Context context) {
        showProgessBar = true;
        this.mSubscriberListener = mSubscriberListener;
        this.context = context;
        mProgressDialogHandler = new ProgressDialogHandler(context);
    }

    public void setShowProgessBar(boolean showProgessBar) {
        this.showProgessBar = showProgessBar;
    }

    private void showProgressDialog() {
        if (mProgressDialogHandler != null && showProgessBar) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    private void dismissProgressDialog() {
        if (mProgressDialogHandler != null && showProgessBar) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mProgressDialogHandler = null;
        }
    }


    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (!NetworkUtil.isNetworkConnected(context)) {
            ToastTool.showToast(context, context.getResources().getString(R.string.no_internet));
        } else if (e instanceof ApiException) {
            ((ApiException) e).ShowError();
        } else {
            ToastTool.showToast(context, context.getResources().getString(R.string.request_fail));
        }
        dismissProgressDialog();
        mSubscriberListener.onError();
    }

    @Override
    public void onComplete() {
        dismissProgressDialog();
        Log.i("complete==>", "ok");
    }

    @Override
    public void onSubscribe(Disposable d) {
        showProgressDialog();
    }

    @Override
    public void onNext(T t) {
        mSubscriberListener.onNext(t);
    }

}