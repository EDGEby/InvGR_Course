package com.example.arrayapp;


import com.example.arrayapp.entity.IntArray;
import com.example.arrayapp.factory.IntArrayFactory;
import com.example.arrayapp.sort.BubbleSort;
import com.example.arrayapp.sort.MergeSort;
import com.example.arrayapp.sort.QuickSort;
import com.example.arrayapp.sort.SortAlgorithm;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    private IntArray unsorted = IntArrayFactory.createFromInts(5,1,4,2,3);

    @Test void testBubbleSort() {
        SortAlgorithm s = new BubbleSort();
        IntArray sorted = s.sort(unsorted);
        assertArrayEquals(new int[]{1,2,3,4,5}, sorted.toArray());
    }

    @Test void testMergeSort() {
        SortAlgorithm s = new MergeSort();
        IntArray sorted = s.sort(unsorted);
        assertArrayEquals(new int[]{1,2,3,4,5}, sorted.toArray());
    }

    @Test void testQuickSort() {
        SortAlgorithm s = new QuickSort();
        IntArray sorted = s.sort(unsorted);
        assertArrayEquals(new int[]{1,2,3,4,5}, sorted.toArray());
    }
}