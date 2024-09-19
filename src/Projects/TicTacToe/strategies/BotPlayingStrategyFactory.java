package src.Projects.TicTacToe.strategies;

import src.Projects.TicTacToe.models.BotDifficultylevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingFactory(BotDifficultylevel botPlayingStrategy){
        if(botPlayingStrategy.equals(BotDifficultylevel.EASY)) {
            return new EasyBotStrategy();
        }
        else if(botPlayingStrategy.equals(BotDifficultylevel.MEDIUM)) {
            return new MediumBotPlayingStrategy();
        }
        else if (botPlayingStrategy.equals(BotDifficultylevel.HARD)) {
            return new HardBotPlayingStrategy();
        }
        return null;
    }
}
