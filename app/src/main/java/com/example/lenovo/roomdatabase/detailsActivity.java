package com.example.lenovo.roomdatabase;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.roomdatabase.roomdatabase.FavoriteMovies;
import com.example.lenovo.roomdatabase.roomdatabase.MyDatabase;

public class detailsActivity extends AppCompatActivity {
    EditText title,rating,poster,description;
    FavoriteMovies fm;
    MyDatabase mydb;
    MovieViewModel viewModel;
    String titl,post,desc;
    Float rat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        title=findViewById(R.id.movie_title);
        rating=findViewById(R.id.movie_rating);
        poster=findViewById(R.id.movie_poster);
        description=findViewById(R.id.movie_description);
        mydb=Room.databaseBuilder(this,MyDatabase.class,"movies db").allowMainThreadQueries().build();
        viewModel= ViewModelProviders.of(this).get(MovieViewModel.class);

    }

    public void Submit(View view) {
        titl=title.getText().toString();
        rat=Float.parseFloat(rating.getText().toString());
        post=poster.getText().toString();
        desc=description.getText().toString();
        if(titl!=null){
            fm=new FavoriteMovies();
            fm.setTitle(titl);
            fm.setDesc(desc);
            fm.setPoster(post);
            fm.setRating(rat);
            mydb.myDAO().insertData(fm);
            Toast.makeText(this,"data added to db",Toast.LENGTH_SHORT).show();
            finish();
        }
        else
        {
            Toast.makeText(this,"add title",Toast.LENGTH_SHORT);
        }
    }
}
