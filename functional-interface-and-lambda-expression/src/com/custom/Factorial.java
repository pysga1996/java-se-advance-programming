package com.custom;

/**
 * @author thanhvt
 * @project functional-interface-and-lambda-expression
 */
@FunctionalInterface
public interface Factorial<T> {
    T produce(T x);
}
