package solitaire;

public abstract class SolitaireImpl implements SolitaireModel{
  private Board board;

  @Override
  public Slot[][] getBoardState() {
    return board.getBoard();
  }

  @Override
  public boolean isGameOver() {
    return (board.getMarbleCount() == 1 || board.hasValidMove());
  }

  @Override
  public int getMarbleCount() {
    return board.getMarbleCount();
  }
}
