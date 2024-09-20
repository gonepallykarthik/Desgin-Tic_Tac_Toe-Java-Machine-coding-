package src.Projects.TicTacToe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    private List<List<Cell>> board;

    public Board() {

    }
    public Board(int dimension) {
        this.size = dimension;
        this.board = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            this.board.add(new ArrayList<>());
            for (int j = 0; j < dimension; j++) {
                this.board.get(i).add(new Cell(i, j));
            }
        }
    }

    public void display() {
        for (int i = 0; i < this.board.size(); i++) {
            for (int j = 0; j < this.board.size(); j++) {
                if (this.board.get(i).get(j).getCellState().equals(CellState.EMPTY)) {
                    System.out.print("|  |");
                } else {
                    System.out.print("|  " + this.board.get(i).get(j).getSymbol() + "  |");
                }
            }
            System.out.println();
        }
    }

    public void rebuildBoard(List<Move> moves) {
        List<List<Cell>> board1 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            board1.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                board1.get(i).add(new Cell(i, j));
            }
        }

        // building entire board
        for (int j = 0; j < moves.size(); j++) {
            Move m = moves.get(j);
            int row = m.getCell().getX();
            int col = m.getCell().getY();
            Symbol sym = m.getCell().getSymbol();
            CellState state = m.getCell().getCellState();

            Cell currentCell = board1.get(row).get(col);
            currentCell.setSymbol(sym);
            currentCell.setCellState(state);

        }

        this.setBoard(board1);
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
