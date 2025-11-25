package com.example.taskport.state.impl;

import com.example.taskport.entity.Ship;
import com.example.taskport.state.ShipState;
import org.apache.logging.log4j.Level;

import java.util.concurrent.TimeUnit;

public class LoadingState implements ShipState {
    @Override
    public void process(Ship ship) {
        log.log(Level.INFO, "{} is loading", ship.getName());
        try {
            TimeUnit.SECONDS.sleep(SECONDS);
            ship.getWarehouse().loadShip(ship);
            ship.setState(new DepartingState());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
