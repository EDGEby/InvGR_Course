package com.example.arrayapp.factory;

import com.example.arrayapp.entity.IntArray;
import com.example.arrayapp.exception.ArrayCreationException;


public final class IntArrayFactory {
    private IntArrayFactory() {}

    public static IntArray createFromInts(int... values) {
        if (values == null) throw new ArrayCreationException("Input values null");
        return IntArray.of(values);
    }
}