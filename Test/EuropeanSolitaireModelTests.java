import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;

public class EuropeanSolitaireModelTests {
  private EuropeanSolitaireModel model;

  /**
   * Tests the toString method in MarbleSolitaireTextView for EuropeanSolitaireModel
   */
  @Test
  public void testToString() {


    EnglishSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireTextView view = new MarbleSolitaireTextView(model);

    String expected =
            "    0 0 0     \n" +
                    "  0 0 0 0 0   \n" +
                    "0 0 0 0 0 0 0 \n" +
                    "0 0 0 _ 0 0 0 \n" +
                    "0 0 0 0 0 0 0 \n" +
                    "  0 0 0 0 0   \n" +
                    "    0 0 0     \n";

    assertEquals(expected, view.toString());
  }

  /**
   * Tests the move method in EuropeanSolitaireModel
   */
  @Test
  public void testCorrectMove() {

    //create the model
    model = new EuropeanSolitaireModel();

    //test that the middle is empty
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model.getSlotAt(5, 3));

    //move a marble to the middle
    model.move(5, 3, 3, 3);

    //check that the marble correctly moved
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model.getSlotAt(5, 3));

  }

  /**
   * Tests the illegalArgumentExceptions in the move
   * method in EuropeanSolitaireModel class
   */
  @Test(expected = IllegalArgumentException.class)
  public void testWrongMove() {

    model = new EuropeanSolitaireModel();

    //no marble to jump over
    model.move(3, 2, 3, 4);

    //move the marble too far
    model.move(3, 0, 3, 3);

    //attempt to move from an empty slot
    model.move(3, 3, 3, 5);

    //attempt to move to an outOfBounds index
    model.move(3, 6, 3, 8);

    //moving a marble to slot 3, 3
    model.move(1, 3, 3, 3);

    //attempt to move a marble to a spot with a marble
    model.move(3, 1, 3, 3);
  }


  /**
   * Tests the illegalArgumentExceptions in the constructors
   * in EnglishSolitaireModel
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor() {

    // tests an even arm thickness
    EuropeanSolitaireModel model1 = new EuropeanSolitaireModel(2);

    // tests for if the given row and column for the empty slot is valid
    EuropeanSolitaireModel model2 = new EuropeanSolitaireModel(0, 0);

    // tests if the given row and column is in bounds
    EuropeanSolitaireModel model3 = new EuropeanSolitaireModel(3, 5, 120);
  }

}
