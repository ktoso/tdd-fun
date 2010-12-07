package tdd.mimuw.movielist.presenter;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import tdd.mimuw.movielist.movies.Movie;
import tdd.mimuw.movielist.view.MovieView;

//todo: dodawanie filmu
//todo: nie moge dodac filmu jesli nazwa jest pusta
//todo: usuwanie nic nie robi jesli nie ma zaznaczonego filmu
//todo: przycisk usuwania jest wylaczony jesli nie ma zaznaczonego filmu

public class MoviePresenterShould {

	private static final String STAR_WARS = "Star wars";
	private MovieView movieView = mock(MovieView.class);

	@Test
	public void addAMovie() throws Exception {
		MovieListPresenter movieListPresenter = presenterWithNoMovies();
		when(movieView.getNewTitle()).thenReturn(STAR_WARS);

		movieListPresenter.add();

		verify(movieView).showMovies(list(movieTitled(STAR_WARS)));
	}

  @Test(expected = NoTextException.class)
	public void dontAllowAddingEmptyMovie() throws Exception {
		MovieListPresenter movieListPresenter = presenterWithNoMovies();
		when(movieView.getNewTitle()).thenReturn("");

		movieListPresenter.add();

		verify(movieView).showMovies(list(movieTitled("")));
	}

	private Movie movieTitled(String title) {
		return new Movie(title);
	}

	private MovieListPresenter presenterWithNoMovies() {
		return new MovieListPresenter(movieView, emptyList(Movie.class));
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
}
