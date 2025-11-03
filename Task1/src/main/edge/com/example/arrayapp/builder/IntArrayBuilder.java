package main.edge.com.example.arrayapp.builder;

import main.edge.com.example.arrayapp.entity.IntArray;
import java.util.ArrayList;
import java.util.List;


public class IntArrayBuilder {
    private final List<Integer> list = new ArrayList<>();

    public IntArrayBuilder add(int value) {
        list.add(value);
        return this;
    }

    public IntArrayBuilder addAll(int... values) {
        if (values != null) for (int v : values) list.add(v);
        return this;
    }

    public IntArray build() {
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) arr[i] = list.get(i);
        return IntArray.of(arr);
    }
}