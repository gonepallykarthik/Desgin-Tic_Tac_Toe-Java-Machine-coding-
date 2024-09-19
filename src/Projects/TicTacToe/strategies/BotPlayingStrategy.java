package src.Projects.TicTacToe.strategies;

import src.Projects.TicTacToe.models.Board;
import src.Projects.TicTacToe.models.Move;
import src.Projects.TicTacToe.models.Player;

public interface BotPlayingStrategy {
    Move decideMove(Board board, Player player);
}
