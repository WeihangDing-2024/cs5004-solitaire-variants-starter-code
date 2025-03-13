package solitaire;

public interface Board {
  boolean hasValidMove();

  Slot[][] getBoard();

  boolean isValidIndex(int row, int col);

  void removeMarble(int row, int col);

  void placeMarble(int row, int col);

  int getMarbleCount();
}
