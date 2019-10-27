package com.bsu.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.bsu.questionandanswerapp.MESSAGE";
    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                TextView info = findViewById(R.id.textView);
                String infoMessage = "info message";
                info.setText(infoMessage);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void sendQuestion(View view) {
        Intent intent = new Intent(this, AnswerActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String question = editText.getText().toString();
        if (!question.equals("")) {
            intent.putExtra(EXTRA_MESSAGE, question);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    public void onClick(View v) {
        sendQuestion(v);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                TextView answerText = findViewById(R.id.textView);
                String answer = intent.getStringExtra(AnswerActivity.EXTRA_ANSWER);
                answerText.setText(answer);
            }
        }
    }

}
