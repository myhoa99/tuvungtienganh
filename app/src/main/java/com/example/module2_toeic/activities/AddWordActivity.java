package com.example.module2_toeic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.module2_toeic.R;
import com.example.module2_toeic.database.DatabaseUtils;
import com.example.module2_toeic.models.NewWordModel;
import com.example.module2_toeic.models.WordModel;

public class AddWordActivity extends AppCompatActivity {

        private NewWordModel newWordModel ;
        private String wordInE, wordInV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
        EditText etWordInEnglish= findViewById(R.id.et_word);
        EditText etWordInVietnamese = findViewById(R.id.et_vietnamese);
        Button btnAddNewWord = findViewById(R.id.btn_add_new_word);
        ImageView ivListWord = findViewById(R.id.iv_list_new_word);

        btnAddNewWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 wordInE=etWordInEnglish.getText().toString();
                 wordInV=etWordInVietnamese.getText().toString();
                DatabaseUtils.getInstance(AddWordActivity.this).writeNewWord(newWordModel,wordInE,wordInV);
                Toast.makeText(AddWordActivity.this, "Add Successfully!", Toast.LENGTH_SHORT).show();
                etWordInEnglish.setText(null);
                etWordInVietnamese.setText(null);
            }
        });

        ivListWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddWordActivity.this,NewWordActivity.class);
                startActivity(intent);
                etWordInEnglish.setText(null);
                etWordInVietnamese.setText(null);
            }
        });
    }
}
