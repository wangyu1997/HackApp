// Generated code from Butter Knife. Do not modify!
package com.njut.igeek.hackapp.UI;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.njut.igeek.hackapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TestActivity_ViewBinding implements Unbinder {
  private TestActivity target;

  private View view2131230812;

  private View view2131230811;

  @UiThread
  public TestActivity_ViewBinding(TestActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TestActivity_ViewBinding(final TestActivity target, View source) {
    this.target = target;

    View view;
    target.testPager = Utils.findRequiredViewAsType(source, R.id.test_pager, "field 'testPager'", ViewPager.class);
    view = Utils.findRequiredView(source, R.id.iv_prev, "field 'ivPrev' and method 'onClick'");
    target.ivPrev = Utils.castView(view, R.id.iv_prev, "field 'ivPrev'", ImageView.class);
    view2131230812 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_next, "field 'ivNext' and method 'onClick'");
    target.ivNext = Utils.castView(view, R.id.iv_next, "field 'ivNext'", ImageView.class);
    view2131230811 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    TestActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.testPager = null;
    target.ivPrev = null;
    target.ivNext = null;

    view2131230812.setOnClickListener(null);
    view2131230812 = null;
    view2131230811.setOnClickListener(null);
    view2131230811 = null;
  }
}
