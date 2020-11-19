package run_multi_threads;

import implement_runnable.MyThread;

public class MoreThreads {
    public static void main(String[] args) {
        System.out.println("Main thread starts running!");
        runMultiThreadUseJoin();
        System.out.println("Main thread has stopped!");
    }

    public static void runMultiThreadUseIsAlive() {
        MyThread mt1 = new MyThread("Child Thread #1");
        MyThread mt2 = new MyThread("Child Thread #2");
        MyThread mt3 = new MyThread("Child Thread #3");
        do {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Main thread has been interrupted!");
            }
        } while (mt1.thrd.isAlive() || mt2.thrd.isAlive() || mt3.thrd.isAlive());
    }

    public static void runMultiThreadUseJoin() {
        MyThread mt1 = new MyThread("Child Thread #1");
        MyThread mt2 = new MyThread("Child Thread #2");
        MyThread mt3 = new MyThread("Child Thread #3");
        try {
            mt1.thrd.join();
            System.out.println("Thread 1 has joined!");
            mt2.thrd.join();
            System.out.println("Thread 2 has joined!");
            mt3.thrd.join();
            System.out.println("Thread 3 has joined!");
        } catch (InterruptedException ex) {
            System.out.println("Main thread has been interrupted!");
        }
    }
}
