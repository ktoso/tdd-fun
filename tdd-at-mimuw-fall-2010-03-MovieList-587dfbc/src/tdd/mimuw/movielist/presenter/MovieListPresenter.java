package tdd.mimuw.movielist.presenter;

import tdd.mimuw.movielist.movies.Movie;
import tdd.mimuw.movielist.view.GuiEventObserver;
import tdd.mimuw.movielist.view.MovieView;

import java.util.List;

public class MovieListPresenter implements GuiEventObserver {

  private final MovieView movieView;
  private List<Movie> movies;

  public MovieListPresenter(MovieView movieView, List<Movie> movies) {
    this.movieView = movieView;
    this.movies = movies;

    // setup initial button status
    toggleDeleteButtonState();
  }

  @Override
  public void onAddMovieClicked() throws EmptyTitleException, DuplicateTitleException {
    addMovie();
  }

  public void addMovie() throws EmptyTitleException, DuplicateTitleException {
    String newTitle = movieView.getNewTitle();
    checkTitle(newTitle);

    movieView.showMovies(movies);
  }

  private void checkTitle(String newTitle) throws EmptyTitleException, DuplicateTitleException {
    if (!hasText(newTitle)) {
      movieView.showMessage("You failed, by adding an empty movie.");
      throw new EmptyTitleException();
    } else if (isDuplicateTitle(newTitle)) {
      throw new DuplicateTitleException();
    } else {
      movies.add(new Movie(newTitle));
    }
  }

    private boolean isDuplicateTitle(String title) {
    for (Movie movie : movies) {
      if (movie.getName().equals(title)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void onMovieSelected() {
    toggleDeleteButtonState();
  }

  public void toggleDeleteButtonState() {
    Movie selectedMovie = movieView.getSelectedMovie();
    movieView.setDeleteButtonEnabled(selectedMovie != null);
  }

  @Override
  public void onRemoveMovieClicked() {
    removeSelectedMovie();
  }

  public void removeSelectedMovie() {
    Movie selectedMovie = movieView.getSelectedMovie();
    removeMovie(selectedMovie);
    onMovieSelected();
  }

  // for testing mainly
  public void removeMovie(Movie selectedMovie) {
    movies.remove(selectedMovie);
  }

  private boolean hasText(String newTitle) {
    if (newTitle == null) {
      return false;
    }
    if (newTitle.length() < 1) {
      return false;
    }
    if (newTitle.trim().equals("")) {
      return false;
    }

    return true;
  }

  public List<Movie> getMovies() {
    return movies;
  }
}
