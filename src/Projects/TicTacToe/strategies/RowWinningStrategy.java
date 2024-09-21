package src.Projects.TicTacToe.strategies;

import src.Projects.TicTacToe.models.Board;
import src.Projects.TicTacToe.models.Move;
import src.Projects.TicTacToe.models.Symbol;

import java.util.HashMap;

public class RowWinningStrategy  implements WinningStrategy{
    private HashMap<Integer, HashMap<Character, Integer>> rowCount = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getX();
        Symbol sym = move.getCell().getSymbol();

        if (!rowCount.containsKey(row)) {
            rowCount.put(row, new HashMap<>());
        }

        HashMap<Character, Integer> counts = rowCount.get(row);
        if (!counts.containsKey(sym.getSym())) {
            counts.put(sym.getSym(), 0);
        }
        counts.put(sym.getSym(), counts.get(sym.getSym()) + 1);
        if (counts.get(sym.getSym()) == board.getSize()) {
            return true;
        }

        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {
        int row = move.getCell().getX();
        Symbol sym = move.getPlayer().getSymbol();

        HashMap<Character, Integer> counts = rowCount.get(row);
        counts.put(sym.getSym(), counts.get(sym.getSym()) - 1);
    }
}
