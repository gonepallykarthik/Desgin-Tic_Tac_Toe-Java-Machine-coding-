package src.Projects.TicTacToe.controllers;

import src.Projects.TicTacToe.Exceptions.EmptyMoveException;
import src.Projects.TicTacToe.Exceptions.InvalidGameConstructionParametersException;
import src.Projects.TicTacToe.models.Game;
import src.Projects.TicTacToe.models.GameStatus;
import src.Projects.TicTacToe.models.Player;
import src.Projects.TicTacToe.strategies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) throws InvalidGameConstructionParametersException {
        return Game.builder()
                .setDimensions(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }
    public void display(Game game) {
        game.display();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    public void makeMove(Game game) {
        try {
            game.makeMove();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public GameStatus checkState(Game game) {
        return game.getGameStatus();
    }

    public void undo(Game game) throws EmptyMoveException {
        game.makeUndo();
    }
    public Player getWinner(Game game) {
        return game.getWinner();
    }
    public void reset(Game game) {

    }
}
