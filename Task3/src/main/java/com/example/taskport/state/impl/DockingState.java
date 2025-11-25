package com.example.taskport.state.impl;

import com.example.taskport.entity.Ship;
import com.example.taskport.state.ShipState;
import org.apache.logging.log4j.Level;

import java.util.concurrent.TimeUnit;

public class DockingState implements ShipState {
    @Override
    public void process(Ship ship) {
        log.log(Level.INFO, "{} is docking to berth", ship.getName());
        try {
            TimeUnit.SECONDS.sleep(1);
            if (ship.getContainersCount() == 0) {
                ship.setState(new LoadingState());
            } else {
                ship.setState(new UnloadingState());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
