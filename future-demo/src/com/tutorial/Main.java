package com.tutorial;

import java.util.concurrent.*;

public class Main {
    private static final FutureHolder futureHolder = new FutureHolder();

    public static void main(String[] args) {
        try {
//            Future<String> msgFuture = futureHolder.calculateAsync();
//            Future<String> msgFuture = futureHolder.supplyAsync();
//            Future<String> msgFuture = futureHolder.supplyAsyncAndApplyFunction();
//            Future<Void> msgFuture = futureHolder.supplyAsyncAndAcceptConsumer();
//            Future<Void> msgFuture = futureHolder.supplyAsyncAndRunRunnable();
//            Future<String> msgFuture = futureHolder.composeFutures();
//            Future<String> msgFuture = futureHolder.combineFutures();
//            Future<Void> msgFuture = futureHolder.acceptBothFutures();
//            Future<Void> msgFuture = futureHolder.runMultipleFuturesInParallelReturnVoid();
//            Future<String> msgFuture = futureHolder.runMultipleFuturesInParallel();
//            CompletableFuture<String> msgFuture = futureHolder.throwErrorsRandomly().handle((s, t) -> s != null ? s : "Hello, stranger");
            Future<String> msgFuture = futureHolder.runAsync();
//            System.out.println(msgFuture.get());
            System.out.println(msgFuture.get(1000, TimeUnit.MILLISECONDS));
//            System.out.println(msgFuture.get(200, TimeUnit.MILLISECONDS));

        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }


}
