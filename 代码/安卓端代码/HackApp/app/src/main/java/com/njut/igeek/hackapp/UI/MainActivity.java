package com.njut.igeek.hackapp.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.njut.igeek.hackapp.Https.HttpMethods;
import com.njut.igeek.hackapp.Https.ProgressSubscriber;
import com.njut.igeek.hackapp.Https.SubscriberListener;

import io.reactivex.Observer;

import com.njut.igeek.hackapp.R;
import com.njut.igeek.hackapp.Tool.JsoupUtil;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

}
