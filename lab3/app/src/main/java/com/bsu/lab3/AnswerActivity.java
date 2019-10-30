package com.bsu.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    public static final String EXTRA_ANSWER = "com.bsu.questionandanswerapp.ANSWER";
    public static final String EXIT = "com.bsu.questionandanswerapp.EXIT";

    private Button sendAnswerBtn;
    private EditText answerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        Intent intent = getIntent();
        String question = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView questionText = findViewById(R.id.textView2);
        questionText.setText(question);
        sendAnswerBtn = findViewById(R.id.button);
        answerTextView = findViewById(R.id.editText);
        answerTextView.setHint(R.string.answer_message);
        sendAnswerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendAnswer(v);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case (R.id.exit):
                ExitDialog exitDialog = new ExitDialog();
                exitDialog.show(getSupportFragmentManager(), "ExitDialog");
                return true;
            case (R.id.info):
                TextView info = findViewById(R.id.textView2);
                String infoMessage = "info message";
                info.setText(infoMessage);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void sendAnswer(View view) {
        Intent intent = new Intent();
        EditText editText = (EditText) findViewById(R.id.editText);
        String answer = editText.getText().toString();
        if (!answer.equals("")) {
            intent.putExtra(EXTRA_ANSWER, answer);
            setResult(RESULT_OK, intent);
            super.finish();
        }
    }


    @Override
    public void finish() {
        exit();
    }


    public void exit() {
        Intent intent = new Intent();
        intent.putExtra(EXIT, EXIT);
        setResult(RESULT_OK, intent);
        super.finish();
    }
}

