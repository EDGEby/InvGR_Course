package org.example.task.reader;

import org.example.task.exception.TextException;


public interface TextReader {
    String readFile(String path) throws TextException;
}
