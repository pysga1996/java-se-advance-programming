package com.tutorial;

public class MyGeneric<T> {
    private T tObject;

    public MyGeneric(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        this.tObject = tClass.newInstance();
    }

    public T getTobject() {
        return tObject;
    }

    public void setTobject(T tobject) {
        this.tObject = tobject;
    }
}
