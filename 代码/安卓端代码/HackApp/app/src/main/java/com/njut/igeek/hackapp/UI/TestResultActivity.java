package com.njut.igeek.hackapp.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.njut.igeek.hackapp.MyApplication;
import com.njut.igeek.hackapp.R;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestResultActivity extends AppCompatActivity {

    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.result)
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result);
        ButterKnife.bind(this);

        Random random = new Random();
        int index = random.nextInt(MyApplication.sMockAnswer.size());
        result.setText(MyApplication.sMockAnswer.get(index));
    }


    @OnClick(R.id.btn_go)
    void onBtnGoClick() {
        //TODO implement
        startActivity(new Intent(this, PicAcvitivity.class));
    }
}
