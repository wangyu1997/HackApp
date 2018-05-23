// Generated code from Butter Knife. Do not modify!
package com.njut.igeek.hackapp.UI;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.njut.igeek.hackapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TestResultActivity_ViewBinding implements Unbinder {
  private TestResultActivity target;

  private View view2131230757;

  @UiThread
  public TestResultActivity_ViewBinding(TestResultActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TestResultActivity_ViewBinding(final TestResultActivity target, View source) {
    this.target = target;

    View view;
    target.img = Utils.findRequiredViewAsType(source, R.id.img, "field 'img'", ImageView.class);
    target.result = Utils.findRequiredViewAsType(source, R.id.result, "field 'result'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_go, "method 'onBtnGoClick'");
    view2131230757 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBtnGoClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    TestResultActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img = null;
    target.result = null;

    view2131230757.setOnClickListener(null);
    view2131230757 = null;
  }
}
