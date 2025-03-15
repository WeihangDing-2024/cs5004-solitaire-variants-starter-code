import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import solitaire.CrossAbstractSolitaireModel;
import solitaire.DiamondSolitaireModel;
import solitaire.Slot;
import solitaire.SolitaireModel;

public class SolitaireMain {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to Solitaire!");
    System.out.print("Select the board you want to play: 1. Cross board. 2. Diamond board. (Enter 1 or 2): ");

    int choiceSelected = -1;
    int choice = 0;

    while (choiceSelected != 1) {
      String input = scanner.nextLine().trim();
      try {
        choice = Integer.parseInt(input);
      } catch (NumberFormatException e) {
        System.out.println("Invalid choice, please enter 1 or 2.");
        continue;
      }
      if (choice < 1 || choice > 3) {
        System.out.println("Invalid choice, please enter 1 or 2.");
        continue;
      }
      choiceSelected = 1;
    }

    // Game loop
    SolitaireModel solitaire = new CrossAbstractSolitaireModel();
    if (choice == 1) {
      solitaire = new CrossAbstractSolitaireModel();
    } else {
      solitaire = new DiamondSolitaireModel();
    }
    startGame(solitaire);
  }

  private static void startGame(SolitaireModel solitaire) {
    Scanner scanner = new Scanner(System.in);
    Collectors Collectors = null;

    System.out.println("Initial board state:");
    while(!solitaire.isGameOver()) {
      printBoard(solitaire);
      System.out.println("Marbles remaining: " + solitaire.getMarbleCount());
      System.out.print(
          "Move a marble, enter 4 integers, indicating from row, from col, to row, to col, seperated by comma: ");
      String input = scanner.nextLine().trim();
      List<Integer> intList;
      try {
        intList = Arrays.stream(input.split(","))
            .map(String::trim)           // Remove any extra whitespace
            .map(Integer::parseInt)      // Convert each string to an int
            .collect(Collectors.toList());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input, try again!");
        continue;
      }
      if (intList.size() != 4) {
        System.out.println("Invalid input, try again!");
        continue;
      }
      try {
        solitaire.move(intList.get(0), intList.get(1), intList.get(2), intList.get(3));
      } catch (IllegalArgumentException e) {
        System.out.println("Invalid input, try again!");
      }
    }
    System.out.println("Game is over!");
  }

  private static void printBoard(SolitaireModel solitaire) {
    Slot[][] board = solitaire.getBoardState();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
}
