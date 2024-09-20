package src.Projects.TicTacToe.models;

import src.Projects.TicTacToe.Exceptions.EmptyMoveException;
import src.Projects.TicTacToe.Exceptions.InvalidGameConstructionParametersException;
import src.Projects.TicTacToe.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private Player winner;
    private int nextPlayerIdx;
    List<WinningStrategy> winningStrategies;


    // make constructor private
    private Game(GameBuilder builder) {
        this.setBoard(new Board(builder.dimensions));
        this.setGameStatus(GameStatus.IN_PROGRESS);
        this.setPlayers(builder.players);
        this.setMoves(new ArrayList<>());
        this.winningStrategies = builder.winningStrategies;
        this.setNextPlayerIdx(0);
    }
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerIdx() {
        return nextPlayerIdx;
    }

    public void setNextPlayerIdx(int nextPlayerIdx) {
        this.nextPlayerIdx = nextPlayerIdx;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }
    public void display(){
        this.board.display();
    }

    public void makeUndo() throws EmptyMoveException{
        if(moves.isEmpty()) {
            throw new EmptyMoveException("There are no moves to undo! ");
        }
        // remove the last move and re-build the state of board
        int index = moves.size() - 1;
        Move lastCell = moves.get(index);

        moves.remove(index);
        int row = lastCell.getCell().getX();
        int col = lastCell.getCell().getY();
        Cell cell = board.getBoard().get(row).get(col);
        cell.setPlayer(null);
        cell.setCellState(CellState.EMPTY);

        nextPlayerIdx-=1;
        nextPlayerIdx = (nextPlayerIdx + players.size()) % players.size();

    }

    private boolean validateMove(Move move) {
        int row = move.getCell().getX();
        int col = move.getCell().getY();

        return row >= 0 && row < board.getSize()
                && col >= 0 && col < board.getSize() && move.getCell().getCellState().equals(CellState.EMPTY);
    }

    public boolean checkWinner(Move move) {
        boolean isWinner = false;
        for (WinningStrategy strategy : winningStrategies) {
            if (strategy.checkWinner(board, move)) {
                isWinner = true;
            }
        }
        return isWinner;
    }
    public void makeMove() {
        Player currentPlayer = players.get(nextPlayerIdx);
        System.out.println("It is " + currentPlayer.getName()+ "'s" + " turn ");
        Move move = currentPlayer.makeMove(board);
        // validate the move
        if(!validateMove(move)) {
            System.out.println("Invalid move! ");
            throw new RuntimeException("Invalid move please try again! ");
        }

        int row = move.getCell().getX();
        int col = move.getCell().getY();

        List<List<Cell>> b = board.getBoard();
        Cell cell = b.get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setSymbol(currentPlayer.getSymbol());
        cell.setPlayer(currentPlayer);

        nextPlayerIdx = (nextPlayerIdx + 1) % players.size();
        move.setCell(cell);
        moves.add(move);

        if(checkWinner(move)) {
            setWinner(currentPlayer);
            setGameStatus(GameStatus.WIN);
        }
        else if (moves.size() == board.getSize() * board.getSize()) {
            setWinner(null);
            setGameStatus(GameStatus.DRAW);
        }
    }

    public static GameBuilder builder() {
        return new GameBuilder();
    }

    public static class GameBuilder {
        private List<Player> players;
        private int dimensions;
        private List<WinningStrategy> winningStrategies;

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public GameBuilder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        private boolean validate() throws InvalidGameConstructionParametersException, Exception{
            if(this.dimensions < 3) {
                throw new InvalidGameConstructionParametersException("Dimension cannot be less than 3");
            }
            if(this.players.size() != this.dimensions - 1) {
                throw new InvalidGameConstructionParametersException("PLayers cannot be less than dimension - 1");
            }

            // TODO : can two player cannot have same character
            for(int i=0; i<players.size(); i++) {
                for(int j=0; j<players.size(); j++) {
                    if(i!=j && players.get(i).getSymbol() == players.get(j).getSymbol()) {
                        throw new InvalidGameConstructionParametersException("No two Players can have same symbol");
                    }
                }
            }

            // TODO: only one player must be Bot
            int bots = 0;
            for(int i=0; i<players.size(); i++) {
                if(players.get(i).getPlayerType().equals(PlayerType.BOT)) {
                    bots++;
                }
            }
            if(bots > 1) {
                throw new InvalidGameConstructionParametersException("Cannot be more than one bot");
            }
            if(this.winningStrategies.isEmpty()) {
                throw new Exception("There should be atleast one winning strategy");
            }

            return true;
        }

        public Game  build() throws InvalidGameConstructionParametersException {
            try{
                validate();
            }
            catch (Exception e) {
                throw new InvalidGameConstructionParametersException(e.getMessage());
            }

            return new Game(this);
        }
    }
}
