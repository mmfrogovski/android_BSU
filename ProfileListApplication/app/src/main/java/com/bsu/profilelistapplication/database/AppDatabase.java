package com.bsu.profilelistapplication.database;

import com.bsu.profilelistapplication.DAO.UserDAO;
import com.bsu.profilelistapplication.entities.User;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDAO userDao();
}
