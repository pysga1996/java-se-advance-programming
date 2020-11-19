package implement_runnable;

import implement_runnable.MyThread;

public class UseThreads {
    public static void main(String[] args) {
        System.out.println("Main thread starts running!");
        runMultiThread();
        System.out.println("Main thread has stopped!");
    }

    private static void runSingleThread() {
        MyThread mt = new MyThread("Child Thread #1");
        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Main thread has been interrupted!");
            }
        }
        System.out.println("Main thread has stopped!");
    }

    private static void runMultiThread() {
        MyThread mt1 = new MyThread("Child Thread #1");
        MyThread mt2 = new MyThread("Child Thread #2");
        MyThread mt3 = new MyThread("Child Thread #3");
        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Main thread has been interrupted!");
            }
        }
    }
}
