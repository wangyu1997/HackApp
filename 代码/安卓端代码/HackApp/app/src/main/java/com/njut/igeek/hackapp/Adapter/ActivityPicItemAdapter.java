package com.njut.igeek.hackapp.Adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.njut.igeek.hackapp.Model.PicModel.DataBean;
import com.njut.igeek.hackapp.R;
import com.njut.igeek.hackapp.UI.PicScrollActivity;

import org.greenrobot.eventbus.EventBus;


public class ActivityPicItemAdapter extends RecyclerView.Adapter<ActivityPicItemAdapter.ViewHolder> {
    private List<DataBean> datas = new ArrayList<>();
    private Context context;

    public ActivityPicItemAdapter(Context context) {
        this.context = context;
    }

    public void updateData(List<DataBean> datas){
        this.datas = datas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_pic_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataBean data = datas.get(position);
        holder.simpleDraweeView.setImageURI(data.getImg_url());
        holder.textView.setText(data.getTitle());
        final  int new_position = position;
        holder.simpleDraweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().postSticky(datas);
                Intent intent = new Intent(context, PicScrollActivity.class);
                intent.putExtra("index", new_position);
                context.startActivity(intent);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView simpleDraweeView;
        private TextView textView;
        private RelativeLayout relativeLayout;

        ViewHolder(View view) {
            super(view);
            simpleDraweeView = view.findViewById(R.id.pic_image);
            textView = view.findViewById(R.id.pic_desc);
            relativeLayout = view.findViewById(R.id.image_layout);
            int width = ((Activity) relativeLayout.getContext()).getWindowManager().getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams params = relativeLayout.getLayoutParams();
            //设置图片的相对于屏幕的宽高比
            params.width = width / 3;
            params.height = (int) (200 + Math.random() * 400);
            relativeLayout.setLayoutParams(params);
        }
    }
}
