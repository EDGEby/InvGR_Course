package com.example.arrayapp.validation.impl;

import com.example.arrayapp.validation.LineValidator;
import java.util.regex.Pattern;

/**
 * Validator for lines representing integer arrays.
 * Example of valid lines:
 *   "1 2 3"
 *   "-5, 6, 7"
 *   "10; -2; 3"
 */
public class ArrayLineValidator implements LineValidator {

    private static final Pattern VALID_PATTERN =
            Pattern.compile("^\\s*([+-]?\\d+\\s*([,;\\-\\s]+\\s*[+-]?\\d+\\s*)*)?$");

    @Override
    public boolean isValid(String line) {
        return VALID_PATTERN.matcher(line).matches();
    }
}
