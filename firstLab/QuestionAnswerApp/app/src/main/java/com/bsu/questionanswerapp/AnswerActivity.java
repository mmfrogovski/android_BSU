package com.bsu.questionanswerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    public static final String EXTRA_ANSWER = "com.bsu.questionanswerapp.ANSWER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        Intent intent = getIntent();
        String question = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.textView);
        if(question!=null)
            textView.setText(question);
    }

    public void sendAnswer(View view){
        Intent intent = new Intent(this, MainActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText2);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_ANSWER, message);
        setResult(RESULT_OK, intent);
        finish();
    }
}
