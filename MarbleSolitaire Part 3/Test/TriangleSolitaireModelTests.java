import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TriangleSolitaireModelTests {

  private TriangleSolitaireModel model;

  /**
   * Tests the move method in TriangleSolitaireModel
   */
  @Test
  public void testCorrectMove() {

    //create the model
    model = new TriangleSolitaireModel();

    //test that the top is empty
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model.getSlotAt(2, 0));

    //move a marble to the top
    model.move(2, 0, 0, 0);

    //check that the marble correctly moved
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model.getSlotAt(2, 0));

  }

  /**
   * Tests the illegalArgumentExceptions in the move
   * method in TriangleSolitaireModel
   */
  @Test(expected = IllegalArgumentException.class)
  public void testWrongMove() {

    model = new TriangleSolitaireModel();

    //no marble to jump over
    model.move(3, 2, 3, 4);

    //move the marble too far
    model.move(3, 0, 3, 3);

    //attempt to move from an empty slot
    model.move(0, 0, 3, 5);

    //attempt to move to an outOfBounds index
    model.move(3, 6, 3, 8);

    //moving a marble to slot 0, 0
    model.move(1, 3, 0, 0);

    //attempt to move a marble to a spot with a marble
    model.move(3, 1, 3, 3);
  }

  /**
   * Tests the initializeBoard method in TriangleSolitaireModel
   */
  @Test
  public void testInitializeBoard() {
    model = new TriangleSolitaireModel();
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model.getSlotAt(3, 3));

    //making sure that the marbles are correctly placed
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model.getSlotAt(4, 4));
  }

  /**
   * Tests the getBoardSize method in TriangleSolitaireModel
   */
  @Test
  public void testGetBoardSize() {
    model = new TriangleSolitaireModel();
    TriangleSolitaireModel model2 = new TriangleSolitaireModel(9);

    //checking a board with arm thickness of 3
    assertEquals(5, model.getBoardSize());
    //checking a board with arm thickness of 5
    assertEquals(9, model2.getBoardSize());
  }

  /**
   * Tests the getSlotAt method in TriangleSolitaireModel
   */
  @Test
  public void testGetSlotAt() {
    model = new TriangleSolitaireModel();

    //checking that the slot at 0, 0 is empty
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model.getSlotAt(0, 0));
    //checking that the slot at 3, 3 is a marble
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model.getSlotAt(3, 3));
  }

  /**
   * Tests the getScore method in TriangleSolitaireModel
   */
  @Test
  public void testGetScore() {
    model = new TriangleSolitaireModel();

    //check the score before a move has been made
    assertEquals(14, model.getScore());

    //move the marble
    model.move(2, 0, 0, 0);

    //check that the score has been updated
    assertEquals(13, model.getScore());
  }

  /**
   * Tests the getScore method in TriangleSolitaireModel
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetScore() {
    model = new TriangleSolitaireModel();

    //conduct an invalid move
    model.move(1, 3, 4, 4);

    //check that the score was not updated
    assertEquals(14, model.getScore());
  }

  /**
   * Tests the isGameOver method in TriangleSolitaireModel
   */
  @Test
  public void testGameOver() {
    model = new TriangleSolitaireModel(3);

    //check that isGameOver is initially false
    assertFalse(model.isGameOver());

    model.move(2, 0, 0, 0);
    model.move(2, 2, 2, 0);

    //check that isGameOver is false
    assertTrue(model.isGameOver());
  }

  /**
   * Tests the isGameOver method in TriangleSolitaireModel
   */
  @Test
  public void testIsGameOver() {
    TriangleSolitaireModel model2 = new TriangleSolitaireModel(1);

    //check that isGameOver is true when only one marble is left
    assertTrue(model2.isGameOver());
  }

  /**
   * Tests the illegalArgumentExceptions in the constructors
   * in TriangleSolitaireModel
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor() {

    // tests an even dimensions
    TriangleSolitaireModel model1 = new TriangleSolitaireModel(2);

    // tests for if the given row and column for the empty slot is valid
    TriangleSolitaireModel model2 = new TriangleSolitaireModel(0, 0);

    // tests if the given row and column is in bounds
    TriangleSolitaireModel model3 = new TriangleSolitaireModel(7, 8, 8);
  }
}
