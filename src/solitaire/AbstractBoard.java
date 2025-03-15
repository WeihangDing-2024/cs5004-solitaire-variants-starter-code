package solitaire;

public abstract class AbstractBoard implements Board{
  protected Slot[][] board;
  protected int marbleCount;
  protected static int MAXSIZE;

  @Override
  public Slot[][] getBoard() {
    Slot[][] copy = new Slot[MAXSIZE][];
    for (int i = 0; i < board.length; i++) {
      copy[i] = board[i].clone();
    }
    return copy;
  }

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
    if (!isValidIndex(row, col) || board[row][col] != Slot.MARBLE) {
      throw new IllegalArgumentException("Invalid index.");
    }
    board[row][col] = Slot.EMPTY;
    marbleCount--;
  }

  @Override
  public void placeMarble(int row, int col) {
    if (!isValidIndex(row, col) || board[row][col] != Slot.EMPTY) {
      throw new IllegalArgumentException("Invalid index.");
    }
    board[row][col] = Slot.MARBLE;
    marbleCount++;
  }

  @Override
  public int getMarbleCount() {
    return marbleCount;
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
    for (int i = row-2; i <= row+2; i++) {
      for (int j = col-2; j <= col+2; j++) {
        if (isValidMove(row, col, i, j)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    // must be valid index
    if (!((isValidIndex(fromRow, fromCol)) && isValidIndex(toRow, toCol))) {
      return false;
    }

    // destination must be empty
    if (board[toRow][toCol] != Slot.EMPTY) {
      return false;
    }

    // distance between start point and destination must be legal
    if (isNotRelativePosition(fromRow, fromCol, toRow, toCol)) {
      return false;
    }

    // middle must be valid and has marble.
    int middleRow = (fromRow + toRow) / 2;
    int middleCol = (fromCol + toCol) / 2;
    if (!isValidIndex(middleRow, middleCol) || getBoard()[middleRow][middleCol] != Slot.MARBLE) {
      return false;
    }
    return true;
  }

  protected abstract boolean isNotRelativePosition(int fromRow, int fromCol, int toRow, int toCol);


}
