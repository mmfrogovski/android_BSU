package com.bsu.primenumbersapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NUMBER = "com.bsu.primenumbersapplication.NUMBER";

    private Button getPrimeNumbersButton;
    private EditText inputForNumber;
    private TextView viewForPrimeNumbers;
    private TextView numberOfPrimeNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.numberOfPrimeNumbers = findViewById(R.id.numberOfPrimes);
        this.getPrimeNumbersButton = findViewById(R.id.button);
        this.inputForNumber = findViewById(R.id.inputForNumber);
        this.viewForPrimeNumbers = findViewById(R.id.primeNumbersList);

        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, new IntentFilter("MainActivity"));
    }


    public void sendNumberToPrimeNumbersService(View view) {
        Intent intent = new Intent(this, PrimeNumbersService.class);
        if (this.inputForNumber.getText() != null) {
            intent.putExtra(EXTRA_NUMBER, this.inputForNumber.getText().toString());
            this.getPrimeNumbersButton.setEnabled(false);
            this.startService(intent);
        }
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent resultIntent) {
            String primeNumbers = resultIntent.getStringExtra("primeNumbers");
            int count = resultIntent.getIntExtra("length", 0);

            viewForPrimeNumbers.setText(primeNumbers);
            numberOfPrimeNumbers.setText("number of prime numbers: " + String.valueOf(count));

            getPrimeNumbersButton.setEnabled(true);
        }
    };
}