// Generated code from Butter Knife. Do not modify!
package com.njut.igeek.hackapp.UI;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.njut.igeek.hackapp.R;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PicScrollActivity_ViewBinding implements Unbinder {
  private PicScrollActivity target;

  @UiThread
  public PicScrollActivity_ViewBinding(PicScrollActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PicScrollActivity_ViewBinding(PicScrollActivity target, View source) {
    this.target = target;

    target.mPositionView = Utils.findRequiredView(source, R.id.position_view, "field 'mPositionView'");
    target.mClose = Utils.findRequiredView(source, R.id.close, "field 'mClose'");
    target.mLinearLayout = Utils.findRequiredViewAsType(source, R.id.linearLayout, "field 'mLinearLayout'", LinearLayout.class);
    target.mIndicatorTv = Utils.findRequiredViewAsType(source, R.id.indicator_tv, "field 'mIndicatorTv'", TextView.class);
    target.mViewpager = Utils.findRequiredViewAsType(source, R.id.viewpager, "field 'mViewpager'", DiscreteScrollView.class);
    target.mBlurView = Utils.findRequiredViewAsType(source, R.id.blurView, "field 'mBlurView'", SimpleDraweeView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PicScrollActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mPositionView = null;
    target.mClose = null;
    target.mLinearLayout = null;
    target.mIndicatorTv = null;
    target.mViewpager = null;
    target.mBlurView = null;
  }
}
