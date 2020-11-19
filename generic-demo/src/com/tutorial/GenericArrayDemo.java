package com.tutorial;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericArrayDemo<T> {
    private T[] array;

    // Contructor.
    public GenericArrayDemo(T[] array) {
        this.array = array;
    }

    public GenericArrayDemo(Class<T> tClass, int size) {
        this.array = (T[]) Array.newInstance(tClass, size);
    }

    public T[] getArray() {
        return array;
    }

    // Trả về phần tử cuối cùng của mảng.
    public T getLastElement() {
        if (this.array == null || this.array.length == 0) {
            return null;
        }
        return this.array[this.array.length - 1];
    }
}
