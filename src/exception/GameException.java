package exception;

public class GameException extends Exception {
    public GameException() {
    }

    public GameException(final String message) {
        super(message);
    }

    public GameException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
