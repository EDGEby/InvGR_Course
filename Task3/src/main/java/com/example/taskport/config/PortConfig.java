package com.example.taskport.config;

import com.example.taskport.entity.Berth;
import com.example.taskport.entity.Ship;
import com.example.taskport.warehouse.Warehouse;

import java.util.List;
import java.util.Queue;

public record PortConfig(Queue<Berth> berths, Warehouse warehouse, List<Ship> ships) {
}
