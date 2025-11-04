package com.example.arrayapp.validation;

/**
 * Common interface for validating lines of text.
 */
public interface LineValidator {
    /**
     * Checks whether the given line matches the expected format.
     *
     * @param line line of text to validate
     * @return true if valid, false otherwise
     */
    boolean isValid(String line);
}
