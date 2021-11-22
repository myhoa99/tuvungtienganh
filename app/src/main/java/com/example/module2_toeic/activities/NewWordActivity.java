package com.example.module2_toeic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.module2_toeic.R;
import com.example.module2_toeic.adapters.NewWordAdapter;
import com.example.module2_toeic.database.DatabaseUtils;
import com.example.module2_toeic.models.NewWordModel;

import java.util.HashMap;
import java.util.List;

public class NewWordActivity extends AppCompatActivity {
    private ListView lvNewWord;
    private NewWordAdapter newWordAdapter;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
         lvNewWord = findViewById(R.id.lv_new_word);
        List<NewWordModel> newWordModels = DatabaseUtils.getInstance(this).getNewWord();
        HashMap<String,List<NewWordModel>> hashMap = DatabaseUtils.getInstance(this).getHashMapNewWord(newWordModels);
        newWordAdapter = new NewWordAdapter(newWordModels,context,hashMap);
        lvNewWord.setAdapter(newWordAdapter);

        Button btnHomePage = findViewById(R.id.btn_home_page);
        btnHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(NewWordActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
