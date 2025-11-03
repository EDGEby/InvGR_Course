package main.edge.com.example.arrayapp.sort;

import main.edge.com.example.arrayapp.entity.IntArray;

public class QuickSort implements SortAlgorithm {
    @Override
    public IntArray sort(IntArray input) {
        int[] a = input.toArray();
        quick(a, 0, a.length - 1);
        return IntArray.of(a);
    }

    private void quick(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(a, lo, hi);
        quick(a, lo, p - 1);
        quick(a, p + 1, hi);
    }

    private int partition(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (a[j] <= pivot) {
                int t = a[i]; a[i] = a[j]; a[j] = t; i++;
            }
        }
        int t = a[i]; a[i] = a[hi]; a[hi] = t;
        return i;
    }
}