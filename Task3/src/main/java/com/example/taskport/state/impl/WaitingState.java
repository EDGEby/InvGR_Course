package com.example.taskport.state.impl;

import com.example.taskport.entity.Berth;
import com.example.taskport.entity.Ship;
import com.example.taskport.state.ShipState;

public class WaitingState implements ShipState {
    @Override
    public void process(Ship ship) {
        try {
            log.info("{} is waiting for free berth", ship.getName());
            Berth berth = ship.getWarehouse().acquireBerth();
            ship.setBerth(berth);
            ship.setState(new DockingState());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

