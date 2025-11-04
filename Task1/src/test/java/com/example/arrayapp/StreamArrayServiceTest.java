package com.example.arrayapp;

import com.example.arrayapp.entity.IntArray;
import com.example.arrayapp.factory.IntArrayFactory;
import com.example.arrayapp.service.StreamArrayService;
import com.example.arrayapp.service.impl.StreamArrayServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StreamArrayServiceTest {
    private final StreamArrayService s = new StreamArrayServiceImpl();

    @Test void testAverage() {
        IntArray arr = IntArrayFactory.createFromInts(2,4,6);
        assertEquals(4.0, s.average(arr), 1e-9);
    }

    @Test void testCounts() {
        IntArray arr = IntArrayFactory.createFromInts(2,4,6);
        assertEquals(3, s.countPositive(arr));
        assertEquals(0, s.countNegative(arr));
    }
}