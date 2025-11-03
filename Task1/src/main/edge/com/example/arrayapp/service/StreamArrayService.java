package main.edge.com.example.arrayapp.service;

import main.edge.com.example.arrayapp.entity.IntArray;
import java.util.Arrays;
import java.util.function.IntPredicate;

public final class StreamArrayService {
    public int min(IntArray arr) {
        return Arrays.stream(arr.toArray()).min().orElseThrow(() -> new IllegalArgumentException("Empty"));
    }

    public int max(IntArray arr) {
        return Arrays.stream(arr.toArray()).max().orElseThrow(() -> new IllegalArgumentException("Empty"));
    }

    public double average(IntArray arr) {
        return Arrays.stream(arr.toArray()).average().orElse(0.0);
    }

    public long sum(IntArray arr) {
        return Arrays.stream(arr.toArray()).asLongStream().sum();
    }

    public long countPositive(IntArray arr) {
        return Arrays.stream(arr.toArray()).filter(v -> v > 0).count();
    }

    public long countNegative(IntArray arr) {
        return Arrays.stream(arr.toArray()).filter(v -> v < 0).count();
    }

    public IntArray replaceIf(IntArray arr, IntPredicate cond, int newValue) {
        int[] res = Arrays.stream(arr.toArray()).map(v -> cond.test(v) ? newValue : v).toArray();
        return IntArray.of(res);
    }
}