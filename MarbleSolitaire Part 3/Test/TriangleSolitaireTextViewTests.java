import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;

public class TriangleSolitaireTextViewTests {

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
