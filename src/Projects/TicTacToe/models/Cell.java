package src.Projects.TicTacToe.models;

public class Cell {
    private int x;
    private int y;
    private Symbol symbol;
    private Player player;
    private CellState cellState;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        this.cellState = CellState.EMPTY;
        this.symbol = null;
        this.player = null;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
