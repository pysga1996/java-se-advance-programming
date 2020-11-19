package com.tutorial;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

public class HelloCallable implements Callable<String> {
    private CompletableFuture<String> completionStage;

    public HelloCallable(CompletableFuture<String> completionStage) {
        this.completionStage = completionStage;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(500);
        completionStage.complete("Hello");
//            completableFuture.cancel(false);
        return null;
    }
}
