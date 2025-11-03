package main.edge.com.example.arrayapp.factory;

import main.edge.com.example.arrayapp.entity.IntArray;


public final class IntArrayFactory {
    private IntArrayFactory() {}

    public static IntArray createFromInts(int... values) {
        if (values == null) throw new ArrayCreationException("Input values null");
        return IntArray.of(values);
    }
}