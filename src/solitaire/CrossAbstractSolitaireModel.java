package solitaire;

// TODO: let user set where the empty marble is.

public class CrossAbstractSolitaireModel extends AbstractSolitaire implements SolitaireModel{

  public CrossAbstractSolitaireModel() {
    board = new CrossBoard();
  }



  public void reset() {
    board = new CrossBoard();
  }
}
