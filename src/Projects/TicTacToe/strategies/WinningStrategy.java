package src.Projects.TicTacToe.strategies;

import src.Projects.TicTacToe.models.Board;
import src.Projects.TicTacToe.models.Move;

public interface WinningStrategy {
    public boolean checkWinner(Board board, Move move);
}
