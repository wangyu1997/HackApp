package com.njut.igeek.hackapp.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.njut.igeek.hackapp.Model.QuestionModel;
import com.njut.igeek.hackapp.R;
import com.njut.igeek.hackapp.Tool.FrescoControllerTool;

import java.util.List;

import lib.lhh.fiv.library.FrescoImageView;

/**
 * Created with idea
 * User: lvdong
 * Date: 2014-03-30
 * Time: 22:20
 */
public class TestAdapter extends EjBasePagerAdapter<QuestionModel> {

    int screenwidth = 1080;
    int screenheight = 1920;

    public TestAdapter(List<QuestionModel> list) {
        super(list);
    }

    public void addModel(QuestionModel questionModel) {
        list.add(questionModel);
        notifyDataSetChanged();
    }

    @Override
    protected EjBasePagerHolder<QuestionModel> onBundHolder(ViewGroup container) {
        return new EjBasePagerHolder<QuestionModel>
                (LayoutInflater.from(container.getContext()).inflate(R.layout.questionfrag_layout, null)) {

            private FrescoImageView mFrescoImageView;
            private TextView mQuestionTv;
            private RadioButton mRbQa;
            private RadioButton mRbQb;
            private RadioButton mRbQc;
            private RadioButton mRbQd;

            @Override
            public void initView() {
                mFrescoImageView = (FrescoImageView) findViewById(R.id.image);
                mQuestionTv = (TextView) findViewById(R.id.question);
                mRbQa = (RadioButton) findViewById(R.id.qa);
                mRbQb = (RadioButton) findViewById(R.id.qb);
                mRbQc = (RadioButton) findViewById(R.id.qc);
                mRbQd = (RadioButton) findViewById(R.id.qd);

            }

            @Override
            public void bindDada(QuestionModel t, int position) {
                String imgUrl = t.getImgUrl();
                String question = t.getQuestion();

                FrescoControllerTool.setControllerListener(mFrescoImageView, imgUrl, screenwidth);
                mQuestionTv.setText(question);
                mRbQa.setText(t.getqA());
                mRbQb.setText(t.getqB());
                mRbQc.setText(t.getqC());
                mRbQd.setText(t.getqD());

            }


        };

    }
}
