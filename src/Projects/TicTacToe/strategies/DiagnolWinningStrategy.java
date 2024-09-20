package src.Projects.TicTacToe.strategies;

import src.Projects.TicTacToe.models.Board;
import src.Projects.TicTacToe.models.Move;

import java.util.HashMap;

public class DiagnolWinningStrategy implements WinningStrategy{
    HashMap<Integer, HashMap<Character, Integer>> leftDiagnol = new HashMap<>();
    HashMap<Integer, HashMap<Character, Integer>> rightDiagnol = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {

        int size = board.getSize();
        int row = move.getCell().getX();
        int col = move.getCell().getY();

        // if it is a main diagnol or left diagnol
        if(row  == col) {

        }

        else if(row + col == size - 1) {

        }

        return false;
    }
}
