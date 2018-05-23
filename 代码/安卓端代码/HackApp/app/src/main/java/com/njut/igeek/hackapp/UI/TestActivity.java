package com.njut.igeek.hackapp.UI;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.njut.igeek.hackapp.Adapter.TestAdapter;
import com.njut.igeek.hackapp.Https.HttpMethods;
import com.njut.igeek.hackapp.Https.ProgressSubscriber;
import com.njut.igeek.hackapp.Https.SubscriberListener;
import com.njut.igeek.hackapp.Model.QuestionModel;
import com.njut.igeek.hackapp.R;
import com.njut.igeek.hackapp.Tool.JsoupUtil;
import com.njut.igeek.hackapp.Tool.NToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;


public class TestActivity extends AppCompatActivity {

    private static final String TAG = "TestActivity";
    public static final int PAGE_SIZE = 10;
    int startIndex = 6130;
    int startPIndex = 1;
    @BindView(R.id.test_pager)
    ViewPager testPager;
    @BindView(R.id.iv_prev)
    ImageView ivPrev;
    @BindView(R.id.iv_next)
    ImageView ivNext;

    TestAdapter mTestAdapter;
    List<QuestionModel> mQuestionModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

        mQuestionModels = new ArrayList<>();
        generateData(startPIndex, startIndex);
        mTestAdapter = new TestAdapter(mQuestionModels);
        testPager.setAdapter(mTestAdapter);
    }

    private void generateData(int pIndex, int index) {
        String mainQCate = "393";
        Log.e(TAG, "generateData: "+pIndex+" "+index );
        getData(mainQCate, pIndex + "", index + "");
    }

    private void getData(String q, String qid, String subQid) {
        Observer<String> getQuestion = new ProgressSubscriber<>(new getQuestionListener(), this);
        HttpMethods.getInstance().getQuestion(getQuestion, q, qid, subQid);

    }


    @OnClick({R.id.iv_prev, R.id.iv_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_prev:
                int index = testPager.getCurrentItem();
                if (index == 0) {
                    NToast.shortToast(TestActivity.this, "已经是第一题");
                    return;
                } else {
                    testPager.setCurrentItem(index - 1);
                    return;
                }
            case R.id.iv_next:
                int index1 = testPager.getCurrentItem();
                if (index1 + 1 == PAGE_SIZE) {
                    NToast.shortToast(TestActivity.this, "已经是最后一题");
                    //GoToResults
                    startActivity(new Intent(this, TestResultActivity.class));

                    return;
                } else {
                    ++startPIndex;
                    ++startIndex;
                    Log.d(TAG, "onClick: " + startPIndex + "," + startIndex);
                    generateData(startPIndex, startIndex);
                    testPager.setCurrentItem(index1 + 1, true);
                    return;
                }
        }
    }


    public class getQuestionListener implements SubscriberListener<String> {
        @Override
        public void onNext(String s) {
//            mQuestionModels.add(JsoupUtil.generate(s));
            mTestAdapter.addModel(JsoupUtil.generate(s));
        }

        @Override
        public void onError() {

        }
    }


}
