// Generated code from Butter Knife. Do not modify!
package com.njut.igeek.hackapp.Adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.njut.igeek.hackapp.R;
import com.njut.igeek.hackapp.View.DragLayout;
import java.lang.IllegalStateException;
import java.lang.Override;
import lib.lhh.fiv.library.FrescoImageView;

public class PicSecondAdapter$MyViewHolder_ViewBinding implements Unbinder {
  private PicSecondAdapter.MyViewHolder target;

  @UiThread
  public PicSecondAdapter$MyViewHolder_ViewBinding(PicSecondAdapter.MyViewHolder target,
      View source) {
    this.target = target;

    target.mImage = Utils.findRequiredViewAsType(source, R.id.image, "field 'mImage'", FrescoImageView.class);
    target.mDragLayout = Utils.findRequiredViewAsType(source, R.id.drag_layout, "field 'mDragLayout'", DragLayout.class);
    target.mPicTitle = Utils.findRequiredViewAsType(source, R.id.pic_title, "field 'mPicTitle'", TextView.class);
    target.mPicDesc = Utils.findRequiredViewAsType(source, R.id.pic_desc, "field 'mPicDesc'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PicSecondAdapter.MyViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mImage = null;
    target.mDragLayout = null;
    target.mPicTitle = null;
    target.mPicDesc = null;
  }
}
