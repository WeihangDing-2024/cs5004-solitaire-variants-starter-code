package solitaire;

public class DiamondSolitaireModel extends AbstractSolitaire implements SolitaireModel{

  public DiamondSolitaireModel() {
    board = new DiamondBoard();
  }

  @Override
  public void reset() {
    board = new DiamondBoard();
  }

}
