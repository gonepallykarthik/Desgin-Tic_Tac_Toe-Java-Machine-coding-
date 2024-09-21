package src.Projects.TicTacToe.strategies;

import src.Projects.TicTacToe.models.Board;
import src.Projects.TicTacToe.models.Move;
import src.Projects.TicTacToe.models.Symbol;

import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy {
    HashMap<Character, Integer> leftDiagonal = new HashMap<>();
    HashMap<Character, Integer> rightDiagonal = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int size = board.getSize();
        int row = move.getCell().getX();
        int col = move.getCell().getY();
        Symbol sym = move.getPlayer().getSymbol();

        // if it is a main diagonal or left diagonal
        if (row == col) {
            leftDiagonal.putIfAbsent(sym.getSym(), 0);
            leftDiagonal.put(sym.getSym(), leftDiagonal.get(sym.getSym()) + 1);

            System.out.println("Left Diagonal: " + leftDiagonal);
            if (leftDiagonal.get(sym.getSym()) == board.getSize()) {
                return true;
            }
        }

        // right diagonal
        if (row + col == size - 1) {
            rightDiagonal.putIfAbsent(sym.getSym(), 0);
            rightDiagonal.put(sym.getSym(), rightDiagonal.get(sym.getSym()) + 1);

            System.out.println("Right Diagonal: " + rightDiagonal);
            if (rightDiagonal.get(sym.getSym()) == size) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {
        int size = board.getSize();
        int row = move.getCell().getX();
        int col = move.getCell().getY();
        Symbol sym = move.getPlayer().getSymbol();

        // left diagonal
        if (row == col) {
            leftDiagonal.put(sym.getSym(), leftDiagonal.get(sym.getSym()) - 1);
        }

        // right diagonal
        if (row + col == size - 1) {
            rightDiagonal.put(sym.getSym(), rightDiagonal.get(sym.getSym()) - 1);
        }
    }
}
