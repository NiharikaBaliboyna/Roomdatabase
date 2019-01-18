package com.example.lenovo.roomdatabase.roomdatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
@Database(entities = FavoriteMovies.class,version = 1,exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public abstract MyDAO myDAO();
}
