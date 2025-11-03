package test.edge.com.example.arrayapp;

import main.edge.com.example.arrayapp.io.FileArrayReader;
import main.edge.com.example.arrayapp.validation.ArrayLineValidator;
import main.edge.com.example.arrayapp.exception.InvalidArrayLineException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileArrayReaderTest {

    @TempDir Path tmpDir;

    @Test void testReadValidFile() throws Exception {
        Path f = tmpDir.resolve("good.txt");
        Files.write(f, List.of("1 2 3", "4,5,6"));
        FileArrayReader reader = new FileArrayReader(new ArrayLineValidator());
        assertDoesNotThrow(() -> {
            var res = reader.readArrays(f);
            assertEquals(2, res.size());
        });
    }

    @Test void testReadInvalidLine() throws IOException {
        Path f = tmpDir.resolve("bad.txt");
        Files.write(f, List.of("1 2 x3", "4 5 6"));
        FileArrayReader reader = new FileArrayReader(new ArrayLineValidator());
        InvalidArrayLineException ex = assertThrows(InvalidArrayLineException.class, () -> reader.readArrays(f));
        assertEquals(1, ex.getLineNumber());
    }
}