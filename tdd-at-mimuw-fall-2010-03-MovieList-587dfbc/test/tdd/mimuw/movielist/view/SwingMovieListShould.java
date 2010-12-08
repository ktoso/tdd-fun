package tdd.mimuw.movielist.view;

import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.testing.FestSwingTestCaseTemplate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tdd.mimuw.movielist.MainApplicationFrame;
import tdd.mimuw.movielist.presenter.DuplicateTitleException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SwingMovieListShould extends FestSwingTestCaseTemplate {

  private FrameFixture window;
  private GuiEventObserver guiEventObserver = mock(GuiEventObserver.class);

  @Before
  public void onSetUp() {
    setUpRobot();
    MainApplicationFrame frame = createMainApplicationFrameInSwingThread();
    window = new FrameFixture(robot(), frame);
    window.show();
  }

  private MainApplicationFrame createMainApplicationFrameInSwingThread() {
    MainApplicationFrame frame = GuiActionRunner
        .execute(new GuiQuery<MainApplicationFrame>() {
          protected MainApplicationFrame executeInEDT() {
            return new MainApplicationFrame(createSwingMovieList());
          }
        });
    return frame;
  }

  private SwingMovieList createSwingMovieList() {
    SwingMovieList swingMovieList = new SwingMovieList();
    swingMovieList.observeWith(guiEventObserver);
    return swingMovieList;
  }

  @After
  public void after() {
    cleanUp();
  }

  @Test
  public void notifyObserverOnAdd() throws Exception {
    window.button("Add").click();

    verify(guiEventObserver).onAddMovieClicked();
  }

  @Test(expected = DuplicateTitleException.class)
  public void addAnMovieByClickingEtc() throws Exception {
    window.textBox("TitleInput").click().deleteText().enterText("Halo");
      window.button("Add").click();

    plzWait(200);
  }

  private void plzWait(int i) {
    try {
      Thread.sleep(i);
    } catch (InterruptedException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
  }
}
