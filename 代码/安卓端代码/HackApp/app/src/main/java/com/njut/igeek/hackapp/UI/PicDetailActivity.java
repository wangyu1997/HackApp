package com.njut.igeek.hackapp.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.njut.igeek.hackapp.Model.PicModel;
import com.njut.igeek.hackapp.R;
import com.njut.igeek.hackapp.Tool.ToastTool;

import lib.lhh.fiv.library.FrescoImageView;

public class PicDetailActivity extends AppCompatActivity {

    private PicModel.DataBean mDataBean;
    private FrescoImageView mFrescoImageView;
    private TextView mPicTitle;
    private TextView mPicDetail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();
    }

    private void init() {
        mFrescoImageView = findViewById(R.id.image);
        mPicTitle = findViewById(R.id.pic_title);
        mPicDetail = findViewById(R.id.pic_desc);
        mDataBean = (PicModel.DataBean) getIntent().getBundleExtra("bundle").getSerializable("pic");
        if (mDataBean == null) {
            ToastTool.init(this);
            ToastTool.showToast("Get Data Failed!");
        } else {
            mFrescoImageView.setImageURI(mDataBean.getImg_url());
            mPicTitle.setText(mDataBean.getTitle());
            mPicDetail.setText(mDataBean.getContent());
        }
    }
}
