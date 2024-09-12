import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EnglishSolitaireModelTests {

  private EnglishSolitaireModel model;

  /**
   * Tests the move method in EnglishSolitaireModel
   */
  @Test
  public void testCorrectMove() {

    //create the model
    model = new EnglishSolitaireModel();

    //test that the middle is empty
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model.getSlotAt(3, 1));

    //move a marble to the middle
    model.move(3, 1, 3, 3);

    //check that the marble correctly moved
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model.getSlotAt(3, 1));

  }

  /**
   * Tests the move method in EnglishSolitaireModel
   */
  @Test
  public void testCorrectMoveDown() {

    model = new EnglishSolitaireModel();

    //valid move down
    model.move(1, 3, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model.getSlotAt(2, 3));
  }

  /**
   * Tests the move method in EnglishSolitaireModel
   */
  @Test
  public void testCorrectMoveRight() {
    model = new EnglishSolitaireModel();

    //valid move right
    model.move(1, 3, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model.getSlotAt(2, 3));

  }

  /**
   * Tests the illegalArgumentExceptions in the move
   * method in EnglishSolitaireModel
   */
  @Test(expected = IllegalArgumentException.class)
  public void testWrongMove() {

    model = new EnglishSolitaireModel();

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
   * Tests the initializeBoard method in EnglishSolitaireModel
   */
  @Test
  public void testInitializeBoard() {
    model = new EnglishSolitaireModel();
    //making sure that the corners are invalid slotStates
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model.getSlotAt(0, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model.getSlotAt(6, 0));

    //making sure that the middle is an empty slotState
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model.getSlotAt(3, 3));

    //making sure that the marbles are correctly placed
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model.getSlotAt(3, 2));
  }

  /**
   * Tests the getBoardSize method in EnglishSolitaireModel
   */
  @Test
  public void testGetBoardSize() {
    model = new EnglishSolitaireModel();
    EnglishSolitaireModel model2 = new EnglishSolitaireModel(5);

    //checking a board with arm thickness of 3
    assertEquals(7, model.getBoardSize());
    //checking a board with arm thickness of 5
    assertEquals(13, model2.getBoardSize());
  }

  /**
   * Tests the getSlotAt method in EnglishSolitaireModel
   */
  @Test
  public void testGetSlotAt() {
    model = new EnglishSolitaireModel();

    //checking that the slot at 3, 3 is empty
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model.getSlotAt(3, 3));
    //checking that the slot at 0, 0 is invalid
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model.getSlotAt(0, 0));
    //checking that the slot at 3, 2 is a marble
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model.getSlotAt(3, 2));
  }

  /**
   * Tests the getScore method in EnglishSolitaireModel
   */
  @Test
  public void testGetScore() {
    model = new EnglishSolitaireModel();

    //check the score before a move has been made
    assertEquals(32, model.getScore());

    //move the marble
    model.move(1, 3, 3, 3);

    //check that the score has been updated
    assertEquals(31, model.getScore());
  }

  /**
   * Tests the getScore method in EnglishSolitaireModel
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetScore() {
    model = new EnglishSolitaireModel();

    //conduct an invalid move
    model.move(4, 5, 6, 3);

    //check that the score was not updated
    assertEquals(32, model.getScore());
  }

  /**
   * Tests the isGameOver method in EnglishSolitaireModel
   */
  @Test
  public void testGameOver() {
    model = new EnglishSolitaireModel();

    //check that isGameOver is initially false
    assertFalse(model.isGameOver());

    //set a marble at 3, 3 to fill up the board
    model.move(1, 3, 3, 3);
    model.move(4, 3, 2, 3);
    model.move(6, 3, 4, 3);
    model.move(3, 1, 3, 3);
    model.move(3, 4, 3, 2);
    model.move(3, 6, 3, 4);

    //check that isGameOver is false
    assertTrue(model.isGameOver());
  }

  /**
   * Tests the isGameOver method in EnglishSolitaireModel
   */
  @Test
  public void testIsGameOver() {
    EnglishSolitaireModel model2 = new EnglishSolitaireModel(1);

    //check that isGameOver is true when only one marble is left
    assertTrue(model2.isGameOver());
  }

  /**
   * Tests the illegalArgumentExceptions in the constructors
   * in EnglishSolitaireModel
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor() {

    // tests an even arm thickness
    EnglishSolitaireModel model1 = new EnglishSolitaireModel(2);

    // tests for if the given row and column for the empty slot is valid
    EnglishSolitaireModel model2 = new EnglishSolitaireModel(0, 0);

    // tests if the given row and column is in bounds
    EnglishSolitaireModel model3 = new EnglishSolitaireModel(3, 5, 120);
  }

}
