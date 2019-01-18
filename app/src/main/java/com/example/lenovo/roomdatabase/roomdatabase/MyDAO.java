package com.example.lenovo.roomdatabase.roomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
@Dao
public interface MyDAO {


    @Query("select * from favoritemovies")
    List<FavoriteMovies> getAllData();


    @Insert
    void insertData(FavoriteMovies fm);


    @Update
    void updateData(FavoriteMovies fm);


    @Delete
    void deleteData(FavoriteMovies fm);
}
