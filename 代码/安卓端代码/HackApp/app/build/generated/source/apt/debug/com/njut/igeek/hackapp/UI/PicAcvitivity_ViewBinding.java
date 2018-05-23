// Generated code from Butter Knife. Do not modify!
package com.njut.igeek.hackapp.UI;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.njut.igeek.hackapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PicAcvitivity_ViewBinding implements Unbinder {
  private PicAcvitivity target;

  @UiThread
  public PicAcvitivity_ViewBinding(PicAcvitivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PicAcvitivity_ViewBinding(PicAcvitivity target, View source) {
    this.target = target;

    target.mRecylerview = Utils.findRequiredViewAsType(source, R.id.recyceView, "field 'mRecylerview'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PicAcvitivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecylerview = null;
  }
}
