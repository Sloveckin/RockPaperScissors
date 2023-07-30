package exception;

public class GameExcepton extends Exception {
    public GameExcepton() {
    }

    public GameExcepton(final String message) {
        super(message);
    }

    public GameExcepton(final String message, final Throwable cause) {
        super(message, cause);
    }
}
