package src.Projects.TicTacToe.models;

import src.Projects.TicTacToe.strategies.BotPlayingStrategy;
import src.Projects.TicTacToe.strategies.BotPlayingStrategyFactory;

public class Bot extends Player{

    private BotDifficultylevel botDifficultylevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, Symbol symbol, PlayerType playerType, BotDifficultylevel botDifficultylevel, BotPlayingStrategy botPlayingStrategy){
        super(name,symbol,playerType);
        this.botDifficultylevel = botDifficultylevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingFactory(botDifficultylevel);
    }
    public Bot(String name, Symbol symbol, BotDifficultylevel botDifficultylevel, BotPlayingStrategy botPlayingStrategy) {
        super(name, symbol, PlayerType.BOT);
        this.botDifficultylevel = botDifficultylevel;
        this.botPlayingStrategy = botPlayingStrategy;
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

//    public Move decideMove(){
//        return botPlayingStrategy.decideMove(this);
//    }
}
