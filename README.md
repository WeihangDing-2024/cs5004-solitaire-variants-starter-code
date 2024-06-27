# Marble Solitaire Game

This project involves implementing two variants of the Marble Solitaire game: a cross-shaped (English style) and a diamond-shaped variant.

## Game Rules

The game consists of a board filled with marbles except for the central slot which is empty. The objective of the game is to remove as many marbles as possible. Marbles are removed by "jumping" an adjacent marble into an empty slot. The jumped-over marble is then removed from the board.

## Interface

You will be implementing the `SolitaireModel` interface, which is provided in the `solitaire` package. The interface is as follows:

```java
package solitaire;

public interface SolitaireModel {

  void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException;

  Slot[][] getBoardState();

  boolean isGameOver();

  int getMarbleCount();

  void reset();
}
```

### Methods

- `move(int fromRow, int fromCol, int toRow, int toCol)`: Makes a move in the game. A move consists of jumping a marble over an adjacent marble into an empty slot. The jumped-over marble is removed. Throws an `IllegalArgumentException` if the move is illegal.

- `getBoardState()`: Returns the current state of the game board as a 2D array of `Slot` enum. Each position can be `Slot.MARBLE` for a marble, `Slot.EMPTY` for an empty slot, or `Slot.FORBIDDEN` for an invalid position.

- `isGameOver()`: Checks if the game is over. The game is over if no more valid moves can be made.

- `getMarbleCount()`: Returns the number of marbles remaining on the board.

- `reset()`: Resets the game to its initial state.

## Implementation

You are required to implement two classes, `CrossSolitaireModel` and `DiamondSolitaireModel`, both of which implement the `SolitaireModel` interface. The `CrossSolitaireModel` class should represent the cross-shaped variant of the game, while the `DiamondSolitaireModel` class should represent the diamond-shaped variant.

## Testing

Ensure to thoroughly test your implementation. Consider edge cases such as invalid moves and game over scenarios.

## Submission

Your submission should include all your Java source files, a comprehensive suite of tests, and a driver class showing us how to use your models.
