package tdd.mimuw.movielist.view;

import tdd.mimuw.movielist.movies.Movie;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

@SuppressWarnings("serial")
public class SwingMovieList extends JPanel implements MovieView {

  private final class DeleteAction extends AbstractAction {
    private DeleteAction() {
      super("Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      guiEventObserver.onRemoveMovieClicked();
    }
  }

  private final class AddAction extends AbstractAction {
    private AddAction() {
      super("Add");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      guiEventObserver.onAddMovieClicked();
    }
  }

  private JList movies;
  private JButton add;
  private JButton delete;
  private MovieListModel moviesModel = new MovieListModel();
  private JTextField newMovieTitle;
  private GuiEventObserver guiEventObserver;

  public SwingMovieList() {
    createComponents();
    layoutComponents();
  }

  private void layoutComponents() {
    setLayout(new BorderLayout());
    add(movies, BorderLayout.CENTER);
    JPanel controls = new JPanel(new BorderLayout());
    JPanel newMovieControls = new JPanel();
    newMovieControls.add(new JLabel("New Movie: "));
    newMovieControls.add(newMovieTitle);
    newMovieControls.add(add);
    controls.add(newMovieControls, BorderLayout.CENTER);
    controls.add(delete, BorderLayout.SOUTH);
    add(controls, BorderLayout.SOUTH);
  }

  private void createComponents() {
    movies = new JList(moviesModel);
    movies.setPreferredSize(new Dimension(100, 300));
    movies.addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent e) {
        guiEventObserver.onMovieSelected();
      }
    });
    add = new JButton(new AddAction());
    add.setName("Add");
    delete = new JButton(new DeleteAction());
    delete.setName("Delete");
    newMovieTitle = new JTextField(26);
  }

  public void observeWith(GuiEventObserver guiEventObserver) {
    this.guiEventObserver = guiEventObserver;
  }

  @Override
  public String getNewTitle() {
    return newMovieTitle.getText();
  }

  @Override
  public void showMovies(List<Movie> movies) {
    moviesModel.update(movies);
  }

  @Override
  public Movie getSelectedMovie() {
    return (Movie) movies.getSelectedValue();
  }

  @Override
  public void setDeleteButtonEnabled(boolean enabled) {
    delete.setEnabled(enabled);
  }

  @Override
  public void showMessage(String message) {
    JOptionPane.showMessageDialog(null, message);
  }

}
