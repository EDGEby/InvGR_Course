package main.edge.com.example.arrayapp.service;

import main.edge.com.example.arrayapp.entity.IntArray;
import java.util.function.IntPredicate;

public final class ArrayService {
    public int min(IntArray arr) {
        int[] a = arr.toArray();
        if (a.length == 0) throw new IllegalArgumentException("Array is empty");
        int m = a[0];
        for (int v : a) if (v < m) m = v;
        return m;
    }

    public int max(IntArray arr) {
        int[] a = arr.toArray();
        if (a.length == 0) throw new IllegalArgumentException("Array is empty");
        int m = a[0];
        for (int v : a) if (v > m) m = v;
        return m;
    }

    public double average(IntArray arr) {
        int[] a = arr.toArray();
        if (a.length == 0) return 0.0;
        long sum = 0;
        for (int v : a) sum += v;
        return (double) sum / a.length;
    }

    public long sum(IntArray arr) {
        long s = 0;
        for (int v : arr.toArray()) s += v;
        return s;
    }

    public int countPositive(IntArray arr) {
        int cnt = 0;
        for (int v : arr.toArray()) if (v > 0) cnt++;
        return cnt;
    }

    public int countNegative(IntArray arr) {
        int cnt = 0;
        for (int v : arr.toArray()) if (v < 0) cnt++;
        return cnt;
    }

    public IntArray replaceIf(IntArray arr, IntPredicate condition, int newValue) {
        int[] a = arr.toArray();
        for (int i = 0; i < a.length; i++) if (condition.test(a[i])) a[i] = newValue;
        return IntArray.of(a);
    }
}