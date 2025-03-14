package solitaire;

public class CrossBoard extends AbstractBoard implements Board{

  public CrossBoard() {
    MAXSIZE = 7;
    board = new Slot[MAXSIZE][MAXSIZE];
    for (int i = 0; i < MAXSIZE; i++) {
      for (int j = 0; j < MAXSIZE; j++) {
        if ((i < 2 || (6-i) < 2) && (j < 2 || (6-j) < 2)) {
          board[i][j] = Slot.FORBIDDEN;
          continue;
        }
        if (i == 3 && j == 3) {
          board[i][j] = Slot.EMPTY;
          continue;
        }
        board[i][j] = Slot.MARBLE;
      }
    }
    marbleCount = 32;
  }

  protected boolean isNotRelativePosition(int fromRow, int fromCol, int toRow, int toCol) {
    // must be valid index
    if (!((isValidIndex(fromRow, fromCol)) || isValidIndex(toRow, toCol))) {
      return true;
    }

    if (fromRow == toRow && Math.abs(fromCol - toCol) == 2) {
      return false;
    }
    if (fromCol == toCol && Math.abs(fromRow - toRow) == 2) {
      return false;
    }
    return true;
  }

}
