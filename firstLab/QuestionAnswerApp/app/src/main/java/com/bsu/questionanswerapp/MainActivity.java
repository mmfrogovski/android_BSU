package com.bsu.questionanswerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.bsu.questionanswerapp.MESSAGE";
    public static final int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendQuestion(View view){
        Intent intent = new Intent(this, AnswerActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        if(requestCode == REQUEST_CODE){
            if(resultCode==RESULT_OK){
                TextView textView = findViewById(R.id.textView2);
                String answer = intent.getStringExtra(AnswerActivity.EXTRA_ANSWER);
                if(answer!=null)
                    textView.setText(answer);
            }
        }
    }
}
