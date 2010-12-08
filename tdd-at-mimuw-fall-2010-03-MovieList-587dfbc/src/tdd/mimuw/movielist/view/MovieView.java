package tdd.mimuw.movielist.view;

import java.util.List;

import tdd.mimuw.movielist.movies.Movie;

import javax.swing.*;

public interface MovieView {

	String getNewTitle();

	void showMovies(List<Movie> movies);

	Movie getSelectedMovie();

  void setDeleteButtonEnabled(boolean enabled);

  void showMessage(String message);
}
