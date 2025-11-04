package com.example.arrayapp.validation;

import java.util.regex.Pattern;

public final class ArrayLineValidator {
    private static final Pattern VALID_PATTERN = Pattern.compile("^\\s*([+-]?\\d+\\s*([,;\\-\\s]+\\s*[+-]?\\d+\\s*)*)?$");

    public boolean isValid(String line) {
        return VALID_PATTERN.matcher(line).matches();
    }
}