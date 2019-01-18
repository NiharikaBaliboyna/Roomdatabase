package com.example.lenovo.roomdatabase;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.lenovo.roomdatabase.roomdatabase.FavoriteMovies;

import java.util.List;

public class MovieViewModel extends ViewModel {
    MutableLiveData<List<FavoriteMovies>> mlist;
    public MovieViewModel()
    {
        mlist=new MutableLiveData<List<FavoriteMovies>>();
    }



    public MutableLiveData<List<FavoriteMovies>> getList() {
        if (mlist == null) {
            mlist = new MutableLiveData<>();
        }
            return mlist;
    }

    public void setList(List<FavoriteMovies> list) {
        mlist.setValue(list);
    }
}
