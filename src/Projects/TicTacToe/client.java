package src.Projects.TicTacToe;

import src.Projects.TicTacToe.Exceptions.EmptyMoveException;
import src.Projects.TicTacToe.Exceptions.InvalidGameConstructionParametersException;
import src.Projects.TicTacToe.controllers.GameController;
import src.Projects.TicTacToe.models.*;
import src.Projects.TicTacToe.strategies.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws InvalidGameConstructionParametersException, EmptyMoveException {
        Scanner sc = new Scanner(System.in);
        GameController gameController = new GameController();
        int dimensions = 3;
        List<Player> players = new ArrayList<>();
        List<WinningStrategy> winningStrategies = new ArrayList<>();
        players.add(new HumanPlayer("John", new Symbol('X',"red"), PlayerType.HUMAN));
        players.add(new Bot( "Bot", new Symbol('O',"Blue"), PlayerType.BOT, BotDifficultylevel.EASY));

        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        Game game = gameController.startGame(dimensions, players, winningStrategies);
        gameController.display(game);

        while (gameController.checkState(game).equals(GameStatus.IN_PROGRESS)) {
            Player currentPlayer = players.get(game.getNextPlayerIdx());
            gameController.makeMove(game);
            gameController.display(game);
            if(!currentPlayer.getPlayerType().equals(PlayerType.BOT)) {
                System.out.println("If you want to Undo the operation Press 'y' or else simply press 'n' for continue ! ");
                String undoResponse = sc.nextLine();
                if (undoResponse.equals("Y") || undoResponse.equals("y")) {
                    System.out.println("Entered !");
                    gameController.undo(game);
                    System.out.println("undo is successful ! ");
                    gameController.display(game);
                }
            }
        }

        if (gameController.checkState(game).equals(GameStatus.WIN)) {
            System.out.println("Winner is " + gameController.getWinner(game).getName());
        } else if (gameController.checkState(game).equals(GameStatus.DRAW)) {
            System.out.println("Game is Draw! ");
        }

    }
}
