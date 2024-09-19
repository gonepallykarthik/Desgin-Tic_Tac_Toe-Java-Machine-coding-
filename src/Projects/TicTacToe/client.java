package src.Projects.TicTacToe;

import src.Projects.TicTacToe.Exceptions.InvalidGameConstructionParametersException;
import src.Projects.TicTacToe.controllers.GameController;
import src.Projects.TicTacToe.models.*;
import src.Projects.TicTacToe.strategies.RowWinningStrategy;
import src.Projects.TicTacToe.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class client {
    public static void main(String[] args) throws InvalidGameConstructionParametersException {
        GameController gameController = new GameController();
        int dimensions = 3;
        List<Player> players = new ArrayList<>();
        List<WinningStrategy> winningStrategies = new ArrayList<>();
        players.add(new HumanPlayer("John", new Symbol('X',"red"), PlayerType.HUMAN));
        players.add(new HumanPlayer("Mark", new Symbol('O', "Blue"), PlayerType.HUMAN));

        winningStrategies.add(new RowWinningStrategy());

        Game game = gameController.startGame(dimensions, players, winningStrategies);

        gameController.display(game);

        while (gameController.checkState(game).equals(GameStatus.IN_PROGRESS)) {
            gameController.display(game);
            gameController.makeMove(game);
        }

        if (gameController.checkState(game).equals(GameStatus.WIN)) {
            System.out.println("Winner is " + gameController.getWinner(game));
        } else if (gameController.checkState(game).equals(GameStatus.DRAW)) {
            System.out.println("Game is Draw! ");
        }

    }
}
