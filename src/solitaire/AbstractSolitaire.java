package solitaire;

public abstract class AbstractSolitaire implements SolitaireModel{
  protected Board board;

  @Override
  public Slot[][] getBoardState() {
    return board.getBoard();
  }

  @Override
  public boolean isGameOver() {
    return (board.getMarbleCount() == 1 || !(board.hasValidMove()));
  }

  @Override
  public int getMarbleCount() {
    return board.getMarbleCount();
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) {

    if (!board.isValidMove(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("Illegal move.");
    }

    // move marble
    board.removeMarble(fromRow, fromCol);
    int middleRow = (fromRow + toRow) / 2;
    int middleCol = (fromCol + toCol) / 2;
    board.removeMarble(middleRow, middleCol);
    board.placeMarble(toRow, toCol);
  }
}
