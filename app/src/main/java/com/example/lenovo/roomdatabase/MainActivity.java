package com.example.lenovo.roomdatabase;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lenovo.roomdatabase.roomdatabase.FavoriteMovies;
import com.example.lenovo.roomdatabase.roomdatabase.MyDAO;
import com.example.lenovo.roomdatabase.roomdatabase.MyDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    MyAdapter myad;
    MyDatabase myDatabase;
    MovieViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);
        myDatabase= Room.databaseBuilder(this,MyDatabase.class,"movies db").allowMainThreadQueries().build();
        List<FavoriteMovies> lists=new ArrayList<>();
        lists= (ArrayList<FavoriteMovies>) myDatabase.myDAO().getAllData();
        viewModel= ViewModelProviders.of(this).get(MovieViewModel.class);
        viewModel.setList(lists);
        Observer<List<FavoriteMovies>> observer=new Observer<List<FavoriteMovies>>() {
            @Override
            public void onChanged(@Nullable List<FavoriteMovies> favoriteMovies) {
                myad=new MyAdapter(MainActivity.this,favoriteMovies);
                rv.setAdapter(myad);
            }
        };
        viewModel.getList().observe(this,observer);
        rv.setLayoutManager(new LinearLayoutManager(this));
      //  rv.setAdapter(myad);

    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.getList().setValue(myDatabase.myDAO().getAllData());
    }

    public void next(View view) {
        Intent i=new Intent(this,detailsActivity.class);
        startActivity(i);
    }
}
