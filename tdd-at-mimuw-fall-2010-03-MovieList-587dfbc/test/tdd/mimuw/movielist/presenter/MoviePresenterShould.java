package tdd.mimuw.movielist.presenter;

import org.junit.Test;
import tdd.mimuw.movielist.movies.Movie;
import tdd.mimuw.movielist.view.MovieView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

//todo: usuwanie w ogóle
//todo: usuwanie nic nie robi jesli nie ma zaznaczonego filmu

public class MoviePresenterShould {

  private static final String STAR_WARS = "Star wars";
  private static final String GATTACA = "GATTACA";
  private static final String MATRIX = "Matrix";
  private static final String EMPTY = "";
  private MovieView movieView = mock(MovieView.class);

  @Test
  public void addAMovie() throws Exception {
    MovieListPresenter movieListPresenter = presenterWithNoMovies();
    when(movieView.getNewTitle()).thenReturn(STAR_WARS);

    movieListPresenter.onAddMovieClicked();

    verify(movieView).showMovies(list(movieTitled(STAR_WARS)));
  }

  @Test(expected = DuplicateTitleException.class)
  public void addDuplicateMovie() throws Exception {
    MovieListPresenter movieListPresenter = presenterWithNoMovies();
    when(movieView.getNewTitle()).thenReturn(STAR_WARS);

    movieListPresenter.onAddMovieClicked();
    movieListPresenter.onAddMovieClicked();
  }

  @Test(expected = EmptyTitleException.class)
  public void dontAllowAddingEmptyMovie() throws Exception {
    MovieListPresenter movieListPresenter = presenterWithNoMovies();
    when(movieView.getNewTitle()).thenReturn(EMPTY);

    movieListPresenter.onAddMovieClicked();


    verify(movieView).showMovies(list(movieTitled(EMPTY)));
  }

  @Test
  public void deleteButtonIsDisabledWithNoSelection() throws Exception {
    MovieListPresenter movieListPresenter = presenterWithMovies();
    when(movieView.getSelectedMovie()).thenReturn(null, movieTitled(MATRIX));

    verify(movieView).setDeleteButtonEnabled(false);

    movieListPresenter.onMovieSelected();
    verify(movieView, atLeastOnce()).setDeleteButtonEnabled(false);

    movieListPresenter.onMovieSelected();
    verify(movieView).setDeleteButtonEnabled(true);
  }

  @Test
  public void deleteButtonIsEnabledWithSelection() throws Exception {
    MovieListPresenter movieListPresenter = presenterWithMovies();
    when(movieView.getSelectedMovie()).thenReturn(movieTitled(MATRIX));

    movieListPresenter.onMovieSelected();

    verify(movieView).setDeleteButtonEnabled(true);
  }

  @Test
  public void removeAnMovie() throws Exception {
    MovieListPresenter movieListPresenter = spy(presenterWithMovies());
    Movie movieToBeRemoved = movieTitled(MATRIX);

    when(movieView.getSelectedMovie()).thenReturn(movieToBeRemoved);

    movieListPresenter.onRemoveMovieClicked();

    verify(movieListPresenter).removeMovie(movieToBeRemoved);
    assertDoesNotContainThisMovie(movieListPresenter.getMovies(), movieToBeRemoved);
  }

  @SuppressWarnings("ALL")
  private MovieListPresenter presenterWithMovies() {
    MovieListPresenter presenter = new MovieListPresenter(movieView, new ArrayList(Arrays.asList(
        movieTitled(STAR_WARS),
        movieTitled(GATTACA),
        movieTitled(MATRIX)
    )));

    return presenter;
  }

  private MovieListPresenter presenterWithNoMovies() {
    MovieListPresenter presenter = new MovieListPresenter(movieView, emptyList(Movie.class));

    return presenter;
  }

  private Movie movieTitled(String title) {
    return new Movie(title);
  }

  private <T> List<T> emptyList(Class<T> clazz) {
    return new ArrayList<T>();
  }

  private <T> List<T> list(T... elements) {
    List<T> list = new ArrayList<T>();
    for (T e : elements) {
      list.add(e);
    }
    return list;
  }

  private void assertDoesNotContainThisMovie(List<Movie> movies, Movie removeMe) {
    for (Movie movie : movies) {
      if (movie.equals(removeMe)) {
        fail("The movie " + removeMe + " should not be in the movies collection.");
      }
    }
  }
}
