package com.example.arrayapp.service;

import com.example.arrayapp.entity.IntArray;
import java.util.function.IntPredicate;


public interface StreamArrayService {

    int min(IntArray arr);

    int max(IntArray arr);

    double average(IntArray arr);

    long sum(IntArray arr);

    long countPositive(IntArray arr);

    long countNegative(IntArray arr);

    IntArray replaceIf(IntArray arr, IntPredicate condition, int newValue);
}
