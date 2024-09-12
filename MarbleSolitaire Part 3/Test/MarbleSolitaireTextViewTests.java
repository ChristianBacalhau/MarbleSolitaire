import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;

public class MarbleSolitaireTextViewTests {


  /**
   * Tests the toString method in MarbleSolitaireTextView
   */
  @Test
  public void testToString() {


    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireTextView view = new MarbleSolitaireTextView(model);

    String expected =
            "    0 0 0     \n" +
                    "    0 0 0     \n" +
                    "0 0 0 0 0 0 0 \n" +
                    "0 0 0 _ 0 0 0 \n" +
                    "0 0 0 0 0 0 0 \n" +
                    "    0 0 0     \n" +
                    "    0 0 0     \n";
    assertEquals(expected, view.toString());
  }

  @Test
  public void testTriToString() {
    TriangleSolitaireModel triModel = new TriangleSolitaireModel();
    TriangleSolitaireTextView view = new TriangleSolitaireTextView(triModel);

    String expected =
            "    _\n" +
                    "   0 0\n" +
                    "  0 0 0\n" +
                    " 0 0 0 0\n" +
                    "0 0 0 0 0\n";
    assertEquals(expected, view.toString());
  }
}



