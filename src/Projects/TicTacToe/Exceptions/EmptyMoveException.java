package src.Projects.TicTacToe.Exceptions;

public class EmptyMoveException extends Exception{
    public EmptyMoveException() {
        super();
    }

    public EmptyMoveException(String message) {
        super(message);
    }

    public EmptyMoveException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyMoveException(Throwable cause) {
        super(cause);
    }

    protected EmptyMoveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
