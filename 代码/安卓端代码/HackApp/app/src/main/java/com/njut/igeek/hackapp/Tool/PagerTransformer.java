package com.njut.igeek.hackapp.Tool;

import android.content.Context;
import android.view.View;

import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.DiscreteScrollItemTransformer;

/**
 * 实现ViewPager左右滑动时的时差
 * Created by xmuSistone on 2016/9/18.
 */
public class PagerTransformer implements DiscreteScrollItemTransformer {

    private int maxTranslateOffsetX;
    private DiscreteScrollView viewPager;

    public PagerTransformer(Context context) {
        this.maxTranslateOffsetX = dp2px(context, 180);
    }

    /**
     * dp和像素转换
     */
    private int dp2px(Context context, float dipValue) {
        float m = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * m + 0.5f);
    }

    @Override
    public void transformItem(View view, float position) {
        if (viewPager == null) {
            viewPager = (DiscreteScrollView) view.getParent();
        }

        int leftInScreen = view.getLeft() - viewPager.getScrollX();
        int centerXInViewPager = leftInScreen + view.getMeasuredWidth() / 2;
        int offsetX = centerXInViewPager - viewPager.getMeasuredWidth() / 2;
        float offsetRate = (float) offsetX * 0.38f / viewPager.getMeasuredWidth();
        float scaleFactor = 1 - Math.abs(offsetRate);
        if (scaleFactor > 0) {
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
            view.setTranslationX(-maxTranslateOffsetX * offsetRate);
        }
    }
}
