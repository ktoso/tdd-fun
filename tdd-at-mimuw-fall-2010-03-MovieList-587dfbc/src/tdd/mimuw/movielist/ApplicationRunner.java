package tdd.mimuw.movielist;

import tdd.mimuw.movielist.movies.Movie;
import tdd.mimuw.movielist.presenter.MovieListPresenter;
import tdd.mimuw.movielist.view.SwingMovieList;

import javax.swing.*;
import java.util.ArrayList;

public class ApplicationRunner {

  public static void main(String[] args) {
    SwingMovieList swingMovieList = new SwingMovieList();
    MovieListPresenter movieListPresenter = new MovieListPresenter(swingMovieList, new ArrayList<Movie>());
    swingMovieList.observeWith(movieListPresenter);

    JFrame frame = new MainApplicationFrame(swingMovieList);
    frame.setVisible(true);
  }
}
