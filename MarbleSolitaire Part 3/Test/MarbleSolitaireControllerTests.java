import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

public class MarbleSolitaireControllerTests {
  private MarbleSolitaireModel model;
  private StringBuilder output;
  private MarbleSolitaireView view;

  @Before
  public void setUp() {
    model = new EnglishSolitaireModel();
    output = new StringBuilder();
    view = new MarbleSolitaireTextView(model, output);
  }

  @Test(expected = IllegalStateException.class)
  public void testInvalidInput() {
    Readable input = new StringReader("4 3 a 4 5 q");
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, view, input);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testExceedMaxAttempts() {
    Readable input = new StringReader("a a a a a a q");
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, view, input);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testQuitGame() {
    Readable input = new StringReader("q");
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, view, input);
    controller.playGame();
  }
}
