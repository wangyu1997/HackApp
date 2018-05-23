// Generated code from Butter Knife. Do not modify!
package com.njut.igeek.hackapp.UI;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.njut.igeek.hackapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GameActivity_ViewBinding implements Unbinder {
  private GameActivity target;

  @UiThread
  public GameActivity_ViewBinding(GameActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public GameActivity_ViewBinding(GameActivity target, View source) {
    this.target = target;

    target.gameWeb = Utils.findRequiredViewAsType(source, R.id.game_web, "field 'gameWeb'", WebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GameActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.gameWeb = null;
  }
}
