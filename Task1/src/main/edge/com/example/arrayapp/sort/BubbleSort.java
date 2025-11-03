package main.edge.com.example.arrayapp.sort;

import main.edge.com.example.arrayapp.entity.IntArray;

public class BubbleSort implements SortAlgorithm {
    @Override
    public IntArray sort(IntArray input) {
        int[] a = input.toArray();
        int n = a.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j]; a[j] = a[j + 1]; a[j + 1] = t;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return IntArray.of(a);
    }
}