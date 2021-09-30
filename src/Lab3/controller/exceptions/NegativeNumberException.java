package Lab3.controller.exceptions;

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(String msg) {
        super(msg);
    }

    public NegativeNumberException() {
    }
}