package com.example.taskport.reader;

import com.example.taskport.exception.PortException;

import java.util.List;

public interface PortFileReader {
    List<String> readFile(String path) throws PortException;
}
