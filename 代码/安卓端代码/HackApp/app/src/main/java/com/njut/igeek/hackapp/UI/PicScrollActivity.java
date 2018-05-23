package com.njut.igeek.hackapp.UI;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.njut.igeek.hackapp.Adapter.PicSecondAdapter;
import com.njut.igeek.hackapp.Https.ProgressDialogHandler;
import com.njut.igeek.hackapp.Model.PicModel;
import com.njut.igeek.hackapp.R;
import com.njut.igeek.hackapp.Tool.PagerTransformer;
import com.yarolegovich.discretescrollview.DiscreteScrollView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Field;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.fresco.processors.BlurPostprocessor;

public class PicScrollActivity extends AppCompatActivity {
    private static final String TAG = "PicDetailLabeledActivit";

    @BindView(R.id.position_view)
    View mPositionView;
    @BindView(R.id.close)
    View mClose;
    @BindView(R.id.linearLayout)
    LinearLayout mLinearLayout;
    @BindView(R.id.indicator_tv)
    TextView mIndicatorTv;
    @BindView(R.id.viewpager)
    DiscreteScrollView mViewpager;
    @BindView(R.id.blurView)
    SimpleDraweeView mBlurView;
    PicSecondAdapter.MyViewHolder mViewHolder;
    boolean closeFlag;
//    @BindView(R.id.viewpager)
//    ViewPager mViewpager;

    private static boolean sIsScrolling;
    private List<PicModel.DataBean> imgs;
    private PicSecondAdapter mViewPagerAdapter;
    private int startIndex;
    private boolean isUnlabel;
    private boolean isLoad;
    private ProgressDialogHandler handler;
    private static PicScrollActivity mPicDetailLabeledActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_second);
        ButterKnife.bind(this);
        handler = new ProgressDialogHandler(this);

        EventBus.getDefault().register(this);

        // 1. 沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(Color.TRANSPARENT);
                getWindow()
                        .getDecorView()
                        .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            } else {
                getWindow()
                        .setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        }

        mPicDetailLabeledActivity = this;
        isLoad = true;
        closeFlag = false;
        startIndex = getIntent().getIntExtra("index", -1);
        dealStatusBar(); // 调整状态栏高度

        initRecyclerViewPager();
    }


    public static PicScrollActivity getInstance() {
        return mPicDetailLabeledActivity;
    }

    public void resumeLoad() {
        isLoad = true;
        mViewPagerAdapter.notifyDataSetChanged();
        handler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
    }

    public void dismissDialog() {
        handler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onUnlabelEvent(List<PicModel.DataBean> list) {
        imgs = list;
    }


    private void initRecyclerViewPager() {
        mViewPagerAdapter = new PicSecondAdapter(this);
        mViewpager.setAdapter(mViewPagerAdapter);
        mViewpager.setItemTransformer(new PagerTransformer(this));
        updateIndicatorTv(startIndex);
        notifyBackgroundChange(startIndex);
        mViewpager.setScrollStateChangeListener(new DiscreteScrollView.ScrollStateChangeListener<RecyclerView.ViewHolder>() {
            private ImagePipeline imagePipeline;
            private int lastPoaition;

            @Override
            public void onScrollStart(RecyclerView.ViewHolder currentItemHolder, int adapterPosition) {
                imagePipeline = Fresco.getImagePipeline();
                imagePipeline.pause();
                lastPoaition = adapterPosition;
                if (currentItemHolder instanceof PicSecondAdapter.MyViewHolder) {
                    closeFlag = true;
                    mViewHolder = (PicSecondAdapter.MyViewHolder) currentItemHolder;
                }
            }

            @Override
            public void onScrollEnd(RecyclerView.ViewHolder currentItemHolder, int adapterPosition) {
                imagePipeline.resume();
                updateIndicatorTv(adapterPosition);
            }

            @Override
            public void onScroll(float scrollPosition) {
                if (closeFlag && mViewHolder != null) {
                    mViewHolder.scrollBack();
                    closeFlag = false;
                }
                imagePipeline.pause();
                notifyBackgroundChange((lastPoaition + 1) % imgs.size());
            }
        });
        mViewPagerAdapter.clearData();
        mViewPagerAdapter.setData(imgs, startIndex);
        mViewpager.scrollToPosition(startIndex);
    }

    private void notifyBackgroundChange(int position) {
        int total = imgs.size();
        ImageRequest request = ImageRequestBuilder.fromRequest(ImageRequest.fromUri(imgs.get((position) % total).getImg_url()))
                .setResizeOptions(new ResizeOptions(200, 300))
                .setPostprocessor(new BlurPostprocessor(this, 20, 4))
                .build();
        PipelineDraweeController controller =
                (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setOldController(mBlurView.getController())
                        .build();
        mBlurView.setController(controller);
    }

    /**
     * 更新指示器
     */
    private void updateIndicatorTv(int index) {
        int totalNum = imgs.size();
        int currentItem = (index + 1) % imgs.size();
        if (currentItem == 0)
            currentItem = totalNum;
        mIndicatorTv.setText(Html.fromHtml("<font color='#12edf0'>" + currentItem + "</font>  /  " + totalNum));
    }

    /**
     * 调整沉浸式菜单的title
     */
    private void dealStatusBar() {

        mClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int statusBarHeight = getStatusBarHeight();
            ViewGroup.LayoutParams lp = mPositionView.getLayoutParams();
            lp.height = statusBarHeight;
            mPositionView.setLayoutParams(lp);
        }

    }

    private int getStatusBarHeight() {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return statusBarHeight;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
