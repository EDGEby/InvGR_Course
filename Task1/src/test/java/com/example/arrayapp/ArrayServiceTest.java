package java.com.example.arrayapp;

import com.example.arrayapp.entity.IntArray;
import com.example.arrayapp.factory.IntArrayFactory;
import com.example.arrayapp.service.ArrayService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayServiceTest {
    private final ArrayService service = new ArrayService();
    private final IntArray arr = IntArrayFactory.createFromInts(1, -2, 3, 4);

    @Test void testMin() { assertEquals(-2, service.min(arr)); }
    @Test void testMax() { assertEquals(4, service.max(arr)); }
    @Test void testSum() { assertEquals(6, service.sum(arr)); }
    @Test void testAverage() { assertEquals(1.5, service.average(arr), 1e-9); }
    @Test void testCountPositive() { assertEquals(3, service.countPositive(arr)); }
    @Test void testCountNegative() { assertEquals(1, service.countNegative(arr)); }

    @Test void testReplaceIf() {
       IntArray a = IntArrayFactory.createFromInts(1,2,3,4);
       IntArray replaced = service.replaceIf(a, v -> v % 2 == 0, 0);
        assertArrayEquals(new int[]{1,0,3,0}, replaced.toArray());
    }
}