package com.example.arrayapp.io.impl;

import com.example.arrayapp.builder.IntArrayBuilder;
import com.example.arrayapp.entity.IntArray;
import com.example.arrayapp.exception.InvalidArrayLineException;
import com.example.arrayapp.io.ArrayReader;
import com.example.arrayapp.validation.LineValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads integer arrays from a text file line by line.
 */
public class FileArrayReader implements ArrayReader {

    private final LineValidator validator;

    public FileArrayReader(LineValidator validator) {
        this.validator = validator;
    }

    @Override
    public List<IntArray> readArrays(Path filePath) throws IOException, InvalidArrayLineException {
        List<IntArray> result = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            String line;
            int lineNo = 0;

            while ((line = br.readLine()) != null) {
                lineNo++;
                line = line.trim();
                if (line.isEmpty()) continue;

                if (!validator.isValid(line)) {
                    throw new InvalidArrayLineException("Invalid line at " + lineNo + ": " + line, lineNo);
                }

                String[] tokens = line.split("[,;\\-\\s]+");
                IntArrayBuilder builder = new IntArrayBuilder();

                for (String token : tokens) {
                    if (!token.isEmpty()) {
                        builder.add(Integer.parseInt(token));
                    }
                }

                result.add(builder.build());
            }
        }

        return result;
    }
}
