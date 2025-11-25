package com.example.taskport.parser;

import com.example.taskport.config.PortConfig;
import com.example.taskport.exception.PortException;

import java.util.List;

public interface PortFileParser {
    PortConfig parseFile(List<String> lines) throws PortException;
}
