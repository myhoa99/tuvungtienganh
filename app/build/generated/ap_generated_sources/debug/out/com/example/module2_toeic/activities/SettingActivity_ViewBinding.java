// Generated code from Butter Knife. Do not modify!
package com.example.module2_toeic.activities;

import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.module2_toeic.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SettingActivity_ViewBinding implements Unbinder {
  private SettingActivity target;

  private View view7f080059;

  private View view7f08005a;

  private View view7f0800b6;

  @UiThread
  public SettingActivity_ViewBinding(SettingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SettingActivity_ViewBinding(final SettingActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.iv_back, "field 'ivBack' and method 'onViewClicked'");
    target.ivBack = Utils.castView(view, R.id.iv_back, "field 'ivBack'", ImageView.class);
    view7f080059 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_done, "field 'ivDone' and method 'onViewClicked'");
    target.ivDone = Utils.castView(view, R.id.iv_done, "field 'ivDone'", ImageView.class);
    view7f08005a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.swReminder = Utils.findRequiredViewAsType(source, R.id.sw_reminder, "field 'swReminder'", Switch.class);
    view = Utils.findRequiredView(source, R.id.tv_time_reminder, "field 'tvTimeReminder' and method 'onViewClicked'");
    target.tvTimeReminder = Utils.castView(view, R.id.tv_time_reminder, "field 'tvTimeReminder'", TextView.class);
    view7f0800b6 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SettingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivBack = null;
    target.ivDone = null;
    target.swReminder = null;
    target.tvTimeReminder = null;

    view7f080059.setOnClickListener(null);
    view7f080059 = null;
    view7f08005a.setOnClickListener(null);
    view7f08005a = null;
    view7f0800b6.setOnClickListener(null);
    view7f0800b6 = null;
  }
}
