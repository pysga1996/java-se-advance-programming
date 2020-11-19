package com.tutorial;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FutureHolder {
    public Future<String> calculateAsync() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
//        Executors.newCachedThreadPool().submit(() -> {
//            Thread.sleep(500);
//            completableFuture.complete("Hello");
////            completableFuture.cancel(false);
//            return null;
//        });
        Executors.newCachedThreadPool().submit(new HelloCallable(completableFuture));
        return completableFuture;
    }

    public Future<String> supplyAsync() {
        return CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            return "Hello";
        });
    }

    public Future<String> supplyAsyncAndApplyFunction() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        Function<String, String> customFunction = (String str) -> {
                                try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            return str + " world";
        };
        return completableFuture.thenApply(customFunction);
    }

    public Future<Void> supplyAsyncAndAcceptConsumer() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        Consumer<String> customConsumer = (String str) -> System.out.println("Computation returned: " + str);
        return completableFuture.thenAccept(customConsumer);
    }

    public Future<Void> supplyAsyncAndRunRunnable() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        Runnable customConsumer = () -> System.out.println("Computation finished");
        return completableFuture.thenRun(customConsumer);
    }

    public Future<String> composeFutures() {
        return CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            return "Hello";
        })
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> {
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    return s + " World";
                }));
    }

    public Future<String> combineFutures() {
        return CompletableFuture.supplyAsync(() -> "Hello")
                .thenCombine(CompletableFuture.supplyAsync(() -> " World"), (s1, s2) -> s1 + s2);
    }

    public Future<Void> acceptBothFutures() {
        return CompletableFuture.supplyAsync(() -> "Hello")
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World"), (s1, s2) -> System.out.println( s1 + s2));
    }

    public Future<Void> runMultipleFuturesInParallelReturnVoid() {
        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "World");

        return CompletableFuture.allOf(future1, future2, future3);
    }

    public Future<String> runMultipleFuturesInParallel() {
        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "World");
//        while (!(future1.isDone() && future2.isDone() && future3.isDone())) {
//
//        }
//        return CompletableFuture.completedFuture(future1.join() + " " + future2.join() + " " + future3.join());
        String combined = Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));
        return CompletableFuture.completedFuture(combined);
    }

    public CompletableFuture<String> throwErrorsRandomly() throws RuntimeException {
        return CompletableFuture.supplyAsync(() -> {
            int randomNumber = (int) Math.round(Math.random() * 10) % 2;
            System.out.println(randomNumber);
            if (randomNumber == 1) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello world";
        });
    }

    public CompletableFuture<String> runAsync() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        return completableFuture.thenApplyAsync(s -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return s + " World";
        });
    }
}
