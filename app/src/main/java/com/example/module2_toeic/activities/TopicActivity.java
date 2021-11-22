package com.example.module2_toeic.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import com.example.module2_toeic.R;
import com.example.module2_toeic.activities.SettingActivity;
import com.example.module2_toeic.adapters.ToeicExpandableListAdapter;
import com.example.module2_toeic.database.DatabaseUtils;
import com.example.module2_toeic.models.CategoryModel;
import com.example.module2_toeic.models.TopicModel;

import java.util.HashMap;
import java.util.List;

public class TopicActivity extends AppCompatActivity {

    private ExpandableListView lvTopics;

    private ToeicExpandableListAdapter toeicExpandableListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        lvTopics = findViewById(R.id.lv_topics);

        List<TopicModel> topicModels = DatabaseUtils.getInstance(this).getListTopic();
        List<CategoryModel> categoryModels = DatabaseUtils.getInstance(this).getListCategory(topicModels);
        HashMap<String, List<TopicModel>> hashMap = DatabaseUtils.getInstance(this)
                .getHashMapTopic(topicModels, categoryModels);

        toeicExpandableListAdapter = new ToeicExpandableListAdapter(categoryModels, hashMap);
        lvTopics.setAdapter(toeicExpandableListAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        toeicExpandableListAdapter.notifyDataSetChanged();
    }



//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        Intent intent = new Intent(this, SettingActivity.class);
//        startActivity(intent);
//        return super.onOptionsItemSelected(item);
//    }
}
