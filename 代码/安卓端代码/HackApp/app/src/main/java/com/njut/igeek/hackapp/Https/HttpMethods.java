package com.njut.igeek.hackapp.Https;

import android.content.Context;
import android.util.Log;


import com.njut.igeek.hackapp.Model.PicModel;
import com.njut.igeek.hackapp.MyApplication;

import java.io.File;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;

import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class HttpMethods {

    private static final String TAG = "HttpMethods";


    private static final int DEFAULT_TIMEOUT = 5;

    private static Context sContext;

    private volatile static HttpMethods instance;

    private Retrofit retrofit;
    private OkHttpClient okHttpClient;
    private APIService mOrcService;

    //构造方法私有
    private HttpMethods() {

        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(
                new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Log.d(TAG, message);
                    }
                });
        loggingInterceptor.setLevel(level);


        okHttpClient = new OkHttpClient().newBuilder()
                .retryOnConnectionFailure(true)
                .cookieJar(MyApplication.getCookieJar())
                .addInterceptor(loggingInterceptor)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://www.baidu.com")
                .build();


        mOrcService = retrofit.create(APIService.class);
    }


    public static void init(Context context) {
        sContext = context;
    }


    public void getQuestion(Observer<String> subscriber, String qId, String subQid, String subsubQid) {
        toSubscribe(mOrcService.getQuize(qId, subQid, subsubQid), subscriber);
    }


    public void getPics(Observer<PicModel> subscriber) {
        toSubscribe(mOrcService.getPics(), subscriber);
    }

    //获取单例
    public static HttpMethods getInstance() {
        if (instance == null) {
            synchronized (HttpMethods.class) {
                if (instance == null) {
                    instance = new HttpMethods();
                }
            }
        }
        return instance;
    }


    //添加线程管理并订阅
    private <T> void toSubscribe(Observable<T> o, Observer<T> s) {
        o.subscribeOn(Schedulers.io())
//                .map(new Function<HttpModel<T>, T>() {
//                    @Override
//                    public T apply(@NonNull HttpModel<T> response) throws Exception {
//                        int code = response.getCode();
//                        if (code != 200) {
//                            throw new ApiException(response.getError(), response.getCode());
//                        } else {
//                            return response.getData();
//                        }
//                    }
//                })
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

}