package com.example.taskport.portMain;

import com.example.taskport.config.PortConfig;
import com.example.taskport.entity.Ship;
import com.example.taskport.exception.PortException;
import com.example.taskport.parser.Impl.PortFileParserImpl;
import com.example.taskport.parser.PortFileParser;
import com.example.taskport.reader.PortFileReader;
import com.example.taskport.reader.impl.PortFileReaderImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PortMain {
    private static final Logger log = LogManager.getLogger();

    static void main() throws PortException{
        PortFileReader reader = new PortFileReaderImpl();
        PortFileParser parser = new PortFileParserImpl();

        List<String> lines = reader.readFile("data/data.txt");
        PortConfig config = parser.parseFile(lines);

        List<Thread> threads = new ArrayList<>();
        for (Ship ship : config.ships()) {
            threads.add(new Thread(ship, ship.getName()));
        }

        threads.forEach(Thread::start);
        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("All ships are served");
    }
}
