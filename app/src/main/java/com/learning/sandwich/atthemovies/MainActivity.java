package com.learning.sandwich.atthemovies;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.learning.sandwich.atthemovies.model.Movies;


import com.learning.sandwich.atthemovies.viewmodel.MoviesViewModel;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ListView moviesListView = findViewById(R.id.movies_list);

    final MoviesViewModel viewModel = ViewModelProviders.of(this).get(MoviesViewModel.class);

    final List<Movies> movieList = new ArrayList<>();
    Movies movie = new Movies();
    movie.setTitle("Casablanca");
    movieList.add(movie);

    final ArrayAdapter<Movies> adapter = new ArrayAdapter<Movies>(this, android.R.layout.simple_list_item_1, movieList);
    moviesListView.setAdapter(adapter);

    Button newMovieButton = findViewById(R.id.new_movie_button);
    newMovieButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        EditText newMovieNameEditText = findViewById(R.id.new_movie_name);
        Movies newMovie = new Movies();
        newMovie.setTitle(newMovieNameEditText.getText().toString());
        viewModel.addMovie(newMovie);
        adapter.notifyDataSetChanged();
      }

    });

  }
}

