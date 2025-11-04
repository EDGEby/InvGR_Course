package com.example.arrayapp.service.impl;

import com.example.arrayapp.entity.IntArray;
import com.example.arrayapp.service.StreamArrayService;

import java.util.Arrays;
import java.util.function.IntPredicate;


public class StreamArrayServiceImpl implements StreamArrayService {

    @Override
    public int min(IntArray arr) {
        return Arrays.stream(arr.toArray())
                .min()
                .orElseThrow(() -> new IllegalArgumentException("Array is empty"));
    }

    @Override
    public int max(IntArray arr) {
        return Arrays.stream(arr.toArray())
                .max()
                .orElseThrow(() -> new IllegalArgumentException("Array is empty"));
    }

    @Override
    public double average(IntArray arr) {
        return Arrays.stream(arr.toArray())
                .average()
                .orElse(0.0);
    }

    @Override
    public long sum(IntArray arr) {
        return Arrays.stream(arr.toArray())
                .asLongStream()
                .sum();
    }

    @Override
    public long countPositive(IntArray arr) {
        return Arrays.stream(arr.toArray())
                .filter(v -> v > 0)
                .count();
    }

    @Override
    public long countNegative(IntArray arr) {
        return Arrays.stream(arr.toArray())
                .filter(v -> v < 0)
                .count();
    }

    @Override
    public IntArray replaceIf(IntArray arr, IntPredicate condition, int newValue) {
        int[] result = Arrays.stream(arr.toArray())
                .map(v -> condition.test(v) ? newValue : v)
                .toArray();
        return IntArray.of(result);
    }
}
