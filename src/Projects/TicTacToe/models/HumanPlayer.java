package src.Projects.TicTacToe.models;

import java.util.Scanner;

public class HumanPlayer extends Player{
    public HumanPlayer(String name, Symbol symbol, PlayerType playerType) {
        super(name,symbol,playerType);
    }

    @Override
    public Move makeMove(Board board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter row to insert a new move");
        int row = sc.nextInt();
        System.out.println("Please Enter col to insert a new move");
        int col = sc.nextInt();
        Move move = new Move(this, new Cell(row, col));
        return move;
    }
}
