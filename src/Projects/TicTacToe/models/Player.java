package src.Projects.TicTacToe.models;

import java.util.Scanner;

public abstract class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

//    public Move decideMove() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please tell row to Insert");
//        int row = sc.nextInt();
//        System.out.println("Please tell column to Insert");
//        int col = sc.nextInt();
//
//        return new Move(this, new Cell(row, col));
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
    public abstract Move makeMove(Board board);
}
