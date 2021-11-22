package com.example.module2_toeic.activities;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.example.module2_toeic.R;
import com.example.module2_toeic.database.DatabaseUtils;
import com.example.module2_toeic.models.TopicModel;
import com.example.module2_toeic.models.WordModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StudyActivity extends AppCompatActivity {
    private static final String TAG = "StudyActivity";

    public static String KEY_TOPIC = "key_topic";
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_name_topic)
    TextView tvNameTopic;
    @BindView(R.id.tv_origin)
    TextView tvOrigin;
    @BindView(R.id.tv_pronun)
    TextView tvPronun;
    @BindView(R.id.tv_details)
    TextView tvDetails;
    @BindView(R.id.tv_explain)
    TextView tvExplain;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.iv_word)
    ImageView ivWord;
    @BindView(R.id.tv_example)
    TextView tvExample;
    @BindView(R.id.tv_example_trans)
    TextView tvExampleTrans;
    @BindView(R.id.tv_didnt_know)
    TextView tvDidntKnow;
    @BindView(R.id.tv_knew)
    TextView tvKnew;
    @BindView(R.id.cl_detail_part)
    ConstraintLayout clDetailPart;
    @BindView(R.id.tv_level)
    TextView tvLevel;
    @BindView(R.id.cl_full)
    ConstraintLayout clFull;
    @BindView(R.id.cv_word)
    CardView cvWord;
    @BindView(R.id.rl_background)
    RelativeLayout rlBackground;
    //    @BindView(R.id.cl_test)
//    ConstraintLayout clTest;
//    @BindView(R.id.tv_test)
//    TextView tvTest;
//    @BindView(R.id.tv_Vietnamese)
//    TextView tvVietnamese;
    @BindView(R.id.et_test)
    EditText etEnglish;
    @BindView(R.id.btn_test)
    Button btnTest;
    //    TextView txttime;
//    CountDownTimer count_obj;
//    Chronometer simplechrono;
    private int preWordId = -1;
    private WordModel wordModel;
    private AnimatorSet animatorSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        ButterKnife.bind(this);
        loadData();
//        txttime = (TextView) findViewById(R.id.txttime);
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat dinhdangngay = new SimpleDateFormat("dd/MM/yyyy");
//        txttime.append(dinhdangngay.format(calendar.getTime()) + "") ;
        Chronometer simplechrono = (Chronometer) findViewById(R.id.txttime);
        simplechrono.start();

    }

    private void nextWord(boolean isKnown) {
        setupAnimation(R.animator.animation_move_to_left);

        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                DatabaseUtils.getInstance(StudyActivity.this)
                        .updateWordLevel(wordModel, isKnown);
                loadData();
                clFull.setLayoutTransition(null);
                changeContent(true);
                changeTest(false);
                setupAnimation(R.animator.animation_move_from_right);
            }
        });
    }

    private void setupAnimation(int animatorId) {
        animatorSet = (AnimatorSet) AnimatorInflater
                .loadAnimator(StudyActivity.this, animatorId);
        animatorSet.setTarget(cvWord);
        animatorSet.start();
    }

    private void loadData() {
        TopicModel topicModel = (TopicModel) getIntent().getSerializableExtra(KEY_TOPIC);

        tvNameTopic.setText(topicModel.getName());
        rlBackground.setBackgroundColor(Color.parseColor(topicModel.getColor()));

        wordModel = DatabaseUtils.getInstance(this).getRandomWord(topicModel.getId(), preWordId);
        preWordId = wordModel.getId();

        tvOrigin.setText(wordModel.getOrigin());
        tvPronun.setText(wordModel.getPronunciation());
        tvType.setText(wordModel.getType());
        tvExplain.setText(wordModel.getExplanation());
        tvExample.setText(wordModel.getExample());
        tvExampleTrans.setText(wordModel.getExample_trans());
        Glide.with(this).load(wordModel.getImageUrl()).into(ivWord);


        switch (wordModel.getLevel()) {
            case 0:
                tvLevel.setText("New word");
                break;
            case 1:
            case 2:
            case 3:
                tvLevel.setText("Review");
                break;
            case 4:
                tvLevel.setText("Master");
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_details, R.id.tv_didnt_know, R.id.tv_knew, R.id.btn_test})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.tv_details:
                clFull.setLayoutTransition(new LayoutTransition());
                changeContent(false);
                break;
            case R.id.tv_didnt_know:
                nextWord(false);
                break;
            case R.id.tv_knew:
                changeTest(true);
                break;
            case R.id.btn_test:
                testData();
                changeTest(false);
//                nextWord(true);
                break;
        }
    }

    private void testData() {
        String wordTest = etEnglish.getText().toString();
        String wordOrigin= wordModel.getOrigin();
        if (wordTest.equals(wordOrigin)==true){
            nextWord(true);
            Toast.makeText(this, "CORRECT!", Toast.LENGTH_SHORT).show();
        }else{
            nextWord(false);
            Toast.makeText(this, "INCORRECT!", Toast.LENGTH_SHORT).show();
        }
        Log.d("testData", "testData:   "+ wordTest+"   "+ wordOrigin);
    }


    private void changeContent(boolean isExpanded) {
        if (isExpanded) {
            clDetailPart.setVisibility(View.GONE);
            tvDetails.setVisibility(View.VISIBLE);
        } else {
            clDetailPart.setVisibility(View.VISIBLE);
            tvDetails.setVisibility(View.GONE);
        }
    }
    private void changeTest(boolean tested){

        if (tested){
            tvOrigin.setVisibility(View.GONE);
            clDetailPart.setVisibility(View.VISIBLE);
            etEnglish.setVisibility(View.VISIBLE);
            btnTest.setVisibility(View.VISIBLE);
            tvExample.setVisibility(View.GONE);
            tvExampleTrans.setVisibility(View.GONE);
            ivWord.setVisibility(View.GONE);
            tvKnew.setVisibility(View.GONE);
            tvDidntKnow.setVisibility(View.GONE);
        }
        else {
            tvOrigin.setVisibility(View.VISIBLE);
            etEnglish.setVisibility(View.GONE);
            btnTest.setVisibility(View.GONE);
            tvExample.setVisibility(View.VISIBLE);
            tvExampleTrans.setVisibility(View.VISIBLE);
            ivWord.setVisibility(View.VISIBLE);
            tvDidntKnow.setVisibility(View.VISIBLE);
            tvKnew.setVisibility(View.VISIBLE);
            etEnglish.setText(null);

        }


    }
}
