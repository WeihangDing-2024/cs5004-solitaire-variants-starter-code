package solitaire;

public class CrossBoard implements Board{
  private Slot[][] board;
  private static int MAXSIZE = 7;

  public CrossBoard() {
    board = new Slot[MAXSIZE][MAXSIZE];
    for (int i = 0; i < MAXSIZE; i++) {
      for (int j = 0; j < MAXSIZE; j++) {
        if ((i < 2 || (6-i) < 2) && (j < 2 || (6-j) < 2)) {
          board[i][j] = Slot.FORBIDDEN;
          continue;
        }
        if (i == 3 && j == 3) {
          board[i][j] = Slot.FORBIDDEN;
          continue;
        }
        board[i][j] = Slot.MARBLE;
      }
    }
  }

  @Override
  public Slot[][] getBoard() {
    return board;
  }

  @Override
  public boolean isValidIndex(int row, int col) {
    if (row < 0 || row >= MAXSIZE || col < 0 || col >= MAXSIZE) {
      return false;
    }
    if (board[row][col] != Slot.FORBIDDEN) {
      return true;
    }
    return false;
  }

  @Override
  public void removeMarble(int row, int col) {
    if (!isValidIndex(row, col)) {
      throw new IllegalArgumentException("Invalid index.");
    }
    board[row][col] = Slot.EMPTY;
  }

  @Override
  public void placeMarble(int row, int col) {
    if (!isValidIndex(row, col)) {
      throw new IllegalArgumentException("Invalid index.");
    }
    board[row][col] = Slot.MARBLE;
  }

  @Override
  public int getMarbleCount() {
    int count = 0;
    for (int i = 0; i < MAXSIZE; i++) {
      for (int j = 0; j < MAXSIZE; j++) {
        if (board[i][j] == Slot.MARBLE) {
          count++;
        }
      }
    }
    return count;
  }

  @Override
  public boolean hasValidMove() {
    if (this.getMarbleCount() == 1) {
      return true;
    }
    for (int i = 0; i < MAXSIZE; i++) {
      for (int j = 0; j < MAXSIZE; j++) {
        if (isValidIndex(i, j)) {
          if (canMove(i, j)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean canMove(int row, int col) {
    if (!isValidIndex(row, col)) {
      throw new IllegalArgumentException("Invalid index.");
    }
    for (int i = -1; i <= 1; i = i + 2) {
      for (int j = -1; j <= 1; j = j + 2) {
        if (isValidIndex(row+i, col+j)) {
          // TODO: 需要位置是marble，且吃掉后也需要valid index
        }

      }
    }
  }
}
