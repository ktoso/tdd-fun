package tdd.mimuw.movielist.presenter;

import tdd.mimuw.movielist.movies.Movie;
import tdd.mimuw.movielist.view.GuiEventObserver;
import tdd.mimuw.movielist.view.MovieView;

import javax.swing.*;
import java.util.List;

public class MovieListPresenter implements GuiEventObserver {

  private final MovieView movieView;
  private List<Movie> movies;

  public MovieListPresenter(MovieView movieView, List<Movie> movies) {
    this.movieView = movieView;
    this.movies = movies;
  }

  public void add() {
    String newTitle = "";
    if (hasText(movieView.getNewTitle())) {
      movies.add(new Movie(newTitle));
    } else {
      JOptionPane.showConfirmDialog(null, "You failed, by adding an empty movie.");
    }
    movieView.showMovies(movies);
  }

  private boolean hasText(String newTitle) {
    if (newTitle == null) {
//      throw new NoTextException();
      return false;
    }
    if (newTitle.trim().equals("")) {
//      throw new NoTextException();
      return false;
    }

    return true;
  }

  public void toggleDeleteButtonState(){
    Movie selectedMovie = movieView.getSelectedMovie();
    movieView.getDeleteField().setEnabled(selectedMovie == null);
  }

}
