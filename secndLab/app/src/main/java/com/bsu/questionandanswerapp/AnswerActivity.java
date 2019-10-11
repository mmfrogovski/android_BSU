package com.bsu.questionandanswerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    public static final String EXTRA_ANSWER = "com.bsu.questionandanswerapp.ANSWER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        Intent intent = getIntent();
        String question = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView questionText = findViewById(R.id.textView2);
        questionText.setText(question);
    }

    public void sendAnswer(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText2);
        String answer = editText.getText().toString();
        if (!answer.equals("")) {
            intent.putExtra(EXTRA_ANSWER, answer);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
