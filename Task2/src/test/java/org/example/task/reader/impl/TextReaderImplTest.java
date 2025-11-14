package org.example.task.reader.impl;

import org.example.task.exception.TextException;
import org.example.task.reader.TextReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextReaderImplTest {

    @Test
    void readFile_success() throws TextException {
        TextReader reader = new TextReaderImpl();
        String text = reader.readFile("data/text.txt");
        assertEquals("Hello world", text.trim());
    }

    @Test
    void readFile_notFound() {
        TextReader reader = new TextReaderImpl();
        assertThrows(TextException.class, () -> reader.readFile("missing.txt"));
    }
}
