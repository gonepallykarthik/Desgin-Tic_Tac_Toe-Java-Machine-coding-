package src.Projects.TicTacToe.strategies;

import src.Projects.TicTacToe.models.Board;
import src.Projects.TicTacToe.models.Move;
import src.Projects.TicTacToe.models.Symbol;

public class CornerWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        int size = board.getSize();
        Symbol sym = move.getPlayer().getSymbol();
        if (board.getBoard().get(0).get(0).getSymbol().getSym() == sym.getSym() &&
                board.getBoard().get(0).get(size - 1).getSymbol().getSym() == sym.getSym() &&
                board.getBoard().get(size - 1).get(0).getSymbol().getSym() == sym.getSym() &&
                board.getBoard().get(size - 1).get(size - 1).getSymbol().getSym() == sym.getSym()) {
            return true;
        }
        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {
        int row = move.getCell().getX();
        int col = move.getCell().getY();

        board.getBoard().get(row).get(col).setSymbol(null);
        board.getBoard().get(row).get(col).setPlayer(null);

    }
}
