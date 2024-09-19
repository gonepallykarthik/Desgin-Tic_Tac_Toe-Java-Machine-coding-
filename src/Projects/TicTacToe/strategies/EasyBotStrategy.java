package src.Projects.TicTacToe.strategies;

import src.Projects.TicTacToe.models.*;

import java.util.List;

public class EasyBotStrategy implements BotPlayingStrategy{
    @Override
    public Move decideMove(Board board, Player player) {
        for (List<Cell> Cells : board.getBoard()) {
            for(Cell cell : Cells) {
                if(cell.getCellState().equals(CellState.EMPTY)) {
                    cell.setSymbol(player.getSymbol());
                    cell.setCellState(CellState.FILLED);
                }
            }
        }
        return null;
    }
}
