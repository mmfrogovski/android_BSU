package com.bsu.primenumbersapplication;

import android.app.IntentService;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class PrimeNumbersService extends IntentService {

    public PrimeNumbersService() {
        super("PrimeNumbersService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String intentValue = intent.getStringExtra(MainActivity.EXTRA_NUMBER);
        int number = Integer.valueOf(intentValue);
        List<Integer> primeNumbers = getPrimeNumbers(number);
        StringBuilder result = new StringBuilder();
        int length = 0;
        for (int primeNumber : primeNumbers) {
            result.append(primeNumber);
            if(primeNumbers.indexOf(primeNumber)!= primeNumbers.size()-1)
                    result.append(", ");
            length++;
        }
        Intent resultIntent = new Intent("MainActivity");
        resultIntent.putExtra("primeNumbers", result.toString());
        resultIntent.putExtra("length", length);

        LocalBroadcastManager.getInstance(this).sendBroadcast(resultIntent);
    }


    public static List<Integer> getPrimeNumbers(int n) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            boolean a = true;
            int q = (int) Math.sqrt(i);
            for (int j = 2; j <= q; j++) {
                if ((i % j) == 0) {
                    a = false;
                    break;
                }
            }
            if (a) {
                numbers.add(i);
            }
        }
        return numbers;
    }
}
