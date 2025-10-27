package test.java.com.example.arrayapp;

import main.java.com.example.arrayapp.entity.IntArray;
import main.java.com.example.arrayapp.factory.IntArrayFactory;
import main.java.com.example.arrayapp.service.ArrayService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayServiceTest {
    private final ArrayService service = new ArrayService();

    @Test
    void testMinMaxSumAvgCounts() {
        IntArray arr = IntArrayFactory.createFromInts(1, -2, 3, 4);
        assertEquals(-2, service.min(arr));
        assertEquals(4, service.max(arr));
        assertEquals(6, service.sum(arr));
        assertEquals(1.5, service.average(arr), 0.0001);
        assertEquals(3, service.countPositive(arr));
        assertEquals(1, service.countNegative(arr));
    }

    @Test
    void testReplaceIf() {
        IntArray arr = IntArrayFactory.createFromInts(1,2,3,4);
        IntArray replaced = service.replaceIf(arr, v -> v % 2 == 0, 0);
        assertArrayEquals(new int[]{1,0,3,0}, replaced.toArray());
    }
}
