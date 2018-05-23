package com.njut.igeek.hackapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.njut.igeek.hackapp.Model.PicModel.DataBean;
import com.njut.igeek.hackapp.R;
import com.njut.igeek.hackapp.Tool.DensityTool;
import com.njut.igeek.hackapp.Tool.FrescoControllerTool;
import com.njut.igeek.hackapp.UI.PicDetailActivity;
import com.njut.igeek.hackapp.View.DragLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lib.lhh.fiv.library.FrescoImageView;

/**
 * Created by ritchiehuang on 04/06/2017.
 */

public class PicSecondAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    //
//    @BindView(R.id.more_btn)
//    ImageView moreBtn;
//    @BindView(R.id.image)
//    FrescoImageView image;
//    @BindView(R.id.aspectCardView)
//    AspectRatioCardView aspectCardView;
//    @BindView(R.id.drag_layout)
//    DragLayout dragLayout;
    private List<DataBean> imgs;
    private Context context;
    private LayoutInflater layoutInflater;
    private int index;
    private float height;
    private float width;

    WindowManager wm;


    int screenwidth = 1080;
    int screenheight = 1920;

    public PicSecondAdapter(Context context) {
        imgs = new ArrayList<>();
        index = 0;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        screenwidth = wm.getDefaultDisplay().getWidth();
        screenheight = wm.getDefaultDisplay().getHeight();
        width = DensityTool.px2dip(context, screenwidth) - 40 * 2 - 60;
        height = (float) (1.2 * width);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.fragment_common, parent, false);
        return new MyViewHolder(rootView);
    }

    public void setData(List<DataBean> data, int index) {
        imgs = data;
        this.index = index;
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (imgs.size() == 0)
            return;
        final int newPosition = position % imgs.size();
        if (holder instanceof MyViewHolder) {
            ViewGroup.LayoutParams params = ((MyViewHolder) holder).mImage.getLayoutParams();
            params.width = DensityTool.dip2px(context, width + 1);
            params.height = DensityTool.dip2px(context, height);
            ((MyViewHolder) holder).mImage.setLayoutParams(params);

            FrescoControllerTool.setController(((MyViewHolder) holder).mImage, imgs.get(newPosition).getImg_url());

            ((MyViewHolder) holder).mPicDesc.setText(imgs.get(position).getContent());
            ((MyViewHolder) holder).mPicTitle.setText(imgs.get(position).getTitle());
            ((MyViewHolder) holder).mDragLayout.setGotoDetailListener(new DragLayout.GotoDetailListener() {
                @Override
                public void gotoDetail() {
                    Intent intent = new Intent(context, PicDetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("pic", imgs.get(newPosition));
                    intent.putExtra("bundle", bundle);
                    context.startActivity(intent);
                }
            });

        }


    }

    @Override
    public int getItemCount() {
        if (imgs.size() > 3)
            return Integer.MAX_VALUE;
        else
            return imgs.size();
    }


    @Override
    public void onClick(View v) {
//        if (mOnItemClickListener != null) {
//            //注意这里使用getTag方法获取数据
//            mOnItemClickListener.onItemClick(v, (PostModel.InfoBean) v.getTag());
//        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        FrescoImageView mImage;
        @BindView(R.id.drag_layout)
        DragLayout mDragLayout;
        @BindView(R.id.pic_title)
        TextView mPicTitle;
        @BindView(R.id.pic_desc)
        TextView mPicDesc;


        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void scrollBack() {
            mDragLayout.scrollBack();
        }

    }

    public void clearData() {
        imgs = new ArrayList<>();
        notifyDataSetChanged();
    }


}
