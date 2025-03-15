package solitaire;

public class DiamondBoard extends AbstractBoard implements Board {

  public DiamondBoard() {
    MAXSIZE = 9;
    board = new Slot[MAXSIZE][MAXSIZE];

    for (int i = 0; i < MAXSIZE; i++) {
      for (int j = 0; j < MAXSIZE; j++) {
        if (i + j < 4 || i + j > 12 || Math.abs(i - j) > 4) {
          board[i][j] = Slot.FORBIDDEN;
        } else {
          board[i][j] = Slot.MARBLE;
        }
      }
    }
    board[4][4] = Slot.EMPTY;
    marbleCount = 40;
  }

  protected boolean isNotRelativePosition(int fromRow, int fromCol, int toRow, int toCol) {
    // must be valid index
    if (!((isValidIndex(fromRow, fromCol)) || isValidIndex(toRow, toCol))) {
      return true;
    }

    if (fromRow == toRow && Math.abs(fromCol - toCol) == 2) {
      return false;
    } else if (fromCol == toCol && Math.abs(fromRow - toRow) == 2) {
      return false;
    } else {
      return Math.abs(fromCol - toCol) != 2 || Math.abs(fromRow - toRow) != 2;
    }
  }
}
