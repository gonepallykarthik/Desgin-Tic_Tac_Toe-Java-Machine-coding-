package src.Projects.TicTacToe.Exceptions;

public class InvalidGameConstructionParametersException extends Exception{
    public InvalidGameConstructionParametersException() {
        super();
    }

    public InvalidGameConstructionParametersException(String message) {
        super(message);
    }

    public InvalidGameConstructionParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidGameConstructionParametersException(Throwable cause) {
        super(cause);
    }

    protected InvalidGameConstructionParametersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
