package src.Projects.TicTacToe.models;

import src.Projects.TicTacToe.strategies.BotPlayingStrategy;
import src.Projects.TicTacToe.strategies.BotPlayingStrategyFactory;

public class Bot extends Player{

    private BotDifficultylevel botDifficultylevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, Symbol symbol, PlayerType playerType, BotDifficultylevel botDifficultylevel){
        super(name,symbol,playerType);
        this.botDifficultylevel = botDifficultylevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingFactory(botDifficultylevel);
    }

    public BotDifficultylevel getBotDifficultylevel() {
        return botDifficultylevel;
    }

    public void setBotDifficultylevel(BotDifficultylevel botDifficultylevel) {
        this.botDifficultylevel = botDifficultylevel;
    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }

    @Override
    public Move makeMove(Board board) {
        return botPlayingStrategy.decideMove(board, this);
    }
}
