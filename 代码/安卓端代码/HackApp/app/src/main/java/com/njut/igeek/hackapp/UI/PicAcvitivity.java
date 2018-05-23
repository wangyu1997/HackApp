package com.njut.igeek.hackapp.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.njut.igeek.hackapp.Adapter.ActivityPicItemAdapter;
import com.njut.igeek.hackapp.Https.HttpMethods;
import com.njut.igeek.hackapp.Https.ProgressSubscriber;
import com.njut.igeek.hackapp.Https.SubscriberListener;
import com.njut.igeek.hackapp.Model.PicModel;
import com.njut.igeek.hackapp.R;
import com.njut.igeek.hackapp.Tool.ToastTool;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wangyu on 2018/4/14.
 */

public class PicAcvitivity extends AppCompatActivity {

    @BindView(R.id.recyceView)
    RecyclerView mRecylerview;
    private ActivityPicItemAdapter activityPicItemAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pics);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mRecylerview = findViewById(R.id.recyceView);
        mRecylerview.setHasFixedSize(true);
        mRecylerview.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        activityPicItemAdapter = new ActivityPicItemAdapter(this);
        mRecylerview.setAdapter(activityPicItemAdapter);

        loadData();
    }

    private void loadData() {
        ;
        ProgressSubscriber<PicModel> subscriber = new ProgressSubscriber<>(new GetPicListener(), this);
        HttpMethods.getInstance().getPics(subscriber);
    }

    public void level1(View view) {
        startLevel(1);
    }

    public void level2(View view) {
        startLevel(2);
    }

    public void level3(View view) {
        startLevel(3);
    }

    public void startLevel(int level) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("level", level);
        startActivity(intent);
    }

    public void test(View view) {
        startActivity(new Intent(this, TestActivity.class));
    }

    public class GetPicListener implements SubscriberListener<PicModel> {

        @Override
        public void onNext(PicModel picModel) {
            if (picModel.getCode() == 200) {
                activityPicItemAdapter.updateData(picModel.getData());
            } else {
                ToastTool.init(PicAcvitivity.this);
                ToastTool.showToast("请求信息失败");
            }
        }

        @Override
        public void onError() {

        }
    }

}
