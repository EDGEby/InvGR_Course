package com.example.arrayapp.io;

import com.example.arrayapp.entity.IntArray;
import com.example.arrayapp.exception.InvalidArrayLineException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;


public interface ArrayReader {
    /**
     * Reads integer arrays from a given file path.
     *
     * @param filePath the path to the source file
     * @return list of IntArray objects
     * @throws IOException if I/O error occurs
     * @throws InvalidArrayLineException if file contains invalid data
     */
    List<IntArray> readArrays(Path filePath) throws IOException, InvalidArrayLineException;
}
