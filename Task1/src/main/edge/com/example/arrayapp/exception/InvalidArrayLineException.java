package main.edge.com.example.arrayapp.exception;

public class InvalidArrayLineException extends Exception {
    private final int lineNumber;
    public InvalidArrayLineException(String message, int lineNumber) {
        super(message);
        this.lineNumber = lineNumber;
    }
    public int getLineNumber() { return lineNumber; }
}