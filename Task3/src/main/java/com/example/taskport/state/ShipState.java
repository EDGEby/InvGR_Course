package com.example.taskport.state;

import com.example.taskport.entity.Ship;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface ShipState {
    Logger log = LogManager.getLogger();
    long SECONDS = (long) (Math.random() * 7 + 2);
    void process(Ship ship);
}
