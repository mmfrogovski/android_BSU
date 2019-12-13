package com.bsu.profilelistapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bsu.profilelistapplication.DAO.UserDAO;
import com.bsu.profilelistapplication.database.AppDatabase;
import com.bsu.profilelistapplication.entities.User;


public class MainActivity extends AppCompatActivity {

    private AppDatabase repository;
    private UserDAO userDao;
    private TextView viewForPrimeNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repository = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();
        userDao = repository.userDao();

        this.viewForPrimeNumbers = findViewById(R.id.usersTextView);

        this.viewForPrimeNumbers.setText(userDao.findAll().toString());
    }

    public void insertUser(View view) {
        User user = new User();
        user.firstName = ((TextView) findViewById(R.id.firstName)).getText().toString();
        user.lastName = ((TextView) findViewById(R.id.lastName)).getText().toString();
        user.age = ((TextView) findViewById(R.id.age)).getText().toString();
        userDao.insertUser(user);
    }

    public void findUser(View view) {
        EditText editTextSearch = findViewById(R.id.searchUser);
        String searchValue = editTextSearch.getText().toString();
        User getUser = userDao.getByNameOrSurname(searchValue);
        TextView textView = findViewById(R.id.searchUserTextView);
        if (getUser != null)
            textView.setText(getUser.toString());
    }

    public void getAllUsers(View view) {
        this.viewForPrimeNumbers.setText(userDao.findAll().toString());
    }
}
