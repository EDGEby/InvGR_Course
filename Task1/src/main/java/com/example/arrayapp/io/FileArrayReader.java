package com.example.arrayapp.io;

import com.example.arrayapp.builder.IntArrayBuilder;
import com.example.arrayapp.entity.IntArray;
import com.example.arrayapp.exception.InvalidArrayLineException;
import com.example.arrayapp.validation.ArrayLineValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileArrayReader {

    private final ArrayLineValidator validator;

    public FileArrayReader(ArrayLineValidator validator) {
        this.validator = validator;
    }

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
                for (String t : tokens) {
                    if (t.isEmpty()) continue;
                    builder.add(Integer.parseInt(t));
                }
                result.add(builder.build());
            }
        }
        return result;
    }
}