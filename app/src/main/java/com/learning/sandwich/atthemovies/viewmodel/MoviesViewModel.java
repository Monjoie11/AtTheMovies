package com.learning.sandwich.atthemovies.viewmodel;

import com.learning.sandwich.atthemovies.model.Movies;
import java.util.ArrayList;
import java.util.List;

public class MoviesViewModel {

  private List<Movies> movies = new ArrayList<>();

  public List<Movies> getMovies(){
    return movies;
  }
  public void addMovie(Movies movies){
    movies.add(movies);
  }
}
