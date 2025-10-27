package main.java.com.example.arrayapp.entity;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class IntArray {
    private static final Logger logger = LogManager.getLogger(IntArray.class);
    private final int[] data;

    private IntArray(int[] arr) {
        this.data = arr == null ? new int[0] : arr.clone();
        logger.debug("IntArray created, length={}", this.data.length);
    }

    static IntArray of(int[] arr) { return new IntArray(arr); }

    public int[] toArray() { return data.clone(); }

    public int get(int idx) { return data[idx]; }

    public int length() { return data.length; }

    @Override
    public String toString() { return Arrays.toString(data); }
}
