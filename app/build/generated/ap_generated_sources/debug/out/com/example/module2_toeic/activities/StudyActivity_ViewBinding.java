// Generated code from Butter Knife. Do not modify!
package com.example.module2_toeic.activities;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.module2_toeic.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StudyActivity_ViewBinding implements Unbinder {
  private StudyActivity target;

  private View view7f080059;

  private View view7f0800a9;

  private View view7f0800aa;

  private View view7f0800af;

  private View view7f080026;

  @UiThread
  public StudyActivity_ViewBinding(StudyActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public StudyActivity_ViewBinding(final StudyActivity target, View source) {
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
    target.tvNameTopic = Utils.findRequiredViewAsType(source, R.id.tv_name_topic, "field 'tvNameTopic'", TextView.class);
    target.tvOrigin = Utils.findRequiredViewAsType(source, R.id.tv_origin, "field 'tvOrigin'", TextView.class);
    target.tvPronun = Utils.findRequiredViewAsType(source, R.id.tv_pronun, "field 'tvPronun'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_details, "field 'tvDetails' and method 'onViewClicked'");
    target.tvDetails = Utils.castView(view, R.id.tv_details, "field 'tvDetails'", TextView.class);
    view7f0800a9 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvExplain = Utils.findRequiredViewAsType(source, R.id.tv_explain, "field 'tvExplain'", TextView.class);
    target.tvType = Utils.findRequiredViewAsType(source, R.id.tv_type, "field 'tvType'", TextView.class);
    target.ivWord = Utils.findRequiredViewAsType(source, R.id.iv_word, "field 'ivWord'", ImageView.class);
    target.tvExample = Utils.findRequiredViewAsType(source, R.id.tv_example, "field 'tvExample'", TextView.class);
    target.tvExampleTrans = Utils.findRequiredViewAsType(source, R.id.tv_example_trans, "field 'tvExampleTrans'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_didnt_know, "field 'tvDidntKnow' and method 'onViewClicked'");
    target.tvDidntKnow = Utils.castView(view, R.id.tv_didnt_know, "field 'tvDidntKnow'", TextView.class);
    view7f0800aa = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_knew, "field 'tvKnew' and method 'onViewClicked'");
    target.tvKnew = Utils.castView(view, R.id.tv_knew, "field 'tvKnew'", TextView.class);
    view7f0800af = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.clDetailPart = Utils.findRequiredViewAsType(source, R.id.cl_detail_part, "field 'clDetailPart'", ConstraintLayout.class);
    target.tvLevel = Utils.findRequiredViewAsType(source, R.id.tv_level, "field 'tvLevel'", TextView.class);
    target.clFull = Utils.findRequiredViewAsType(source, R.id.cl_full, "field 'clFull'", ConstraintLayout.class);
    target.cvWord = Utils.findRequiredViewAsType(source, R.id.cv_word, "field 'cvWord'", CardView.class);
    target.rlBackground = Utils.findRequiredViewAsType(source, R.id.rl_background, "field 'rlBackground'", RelativeLayout.class);
    target.etEnglish = Utils.findRequiredViewAsType(source, R.id.et_test, "field 'etEnglish'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_test, "field 'btnTest' and method 'onViewClicked'");
    target.btnTest = Utils.castView(view, R.id.btn_test, "field 'btnTest'", Button.class);
    view7f080026 = view;
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
    StudyActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivBack = null;
    target.tvNameTopic = null;
    target.tvOrigin = null;
    target.tvPronun = null;
    target.tvDetails = null;
    target.tvExplain = null;
    target.tvType = null;
    target.ivWord = null;
    target.tvExample = null;
    target.tvExampleTrans = null;
    target.tvDidntKnow = null;
    target.tvKnew = null;
    target.clDetailPart = null;
    target.tvLevel = null;
    target.clFull = null;
    target.cvWord = null;
    target.rlBackground = null;
    target.etEnglish = null;
    target.btnTest = null;

    view7f080059.setOnClickListener(null);
    view7f080059 = null;
    view7f0800a9.setOnClickListener(null);
    view7f0800a9 = null;
    view7f0800aa.setOnClickListener(null);
    view7f0800aa = null;
    view7f0800af.setOnClickListener(null);
    view7f0800af = null;
    view7f080026.setOnClickListener(null);
    view7f080026 = null;
  }
}
