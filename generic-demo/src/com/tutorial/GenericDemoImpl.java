package com.tutorial;

public class GenericDemoImpl<G> implements GenericInterfaceDemo<G> {
    private G something;

    @Override
    public G dosomething() {
        return something;
    }
}
