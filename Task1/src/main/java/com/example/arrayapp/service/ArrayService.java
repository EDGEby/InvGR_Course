package com.example.arrayapp.service;

import com.example.arrayapp.entity.IntArray;
import java.util.function.IntPredicate;

public interface ArrayService {
    int min(IntArray arr);
    int max(IntArray arr);
    double average(IntArray arr);
    long sum(IntArray arr);
    int countPositive(IntArray arr);
    int countNegative(IntArray arr);
    IntArray replaceIf(IntArray arr, IntPredicate condition, int newValue);
}
