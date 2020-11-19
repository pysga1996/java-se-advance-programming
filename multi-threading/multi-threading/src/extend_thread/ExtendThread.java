package extend_thread;

import extend_thread.MyAdvancedThread;

public class ExtendThread {
    public static void main(String[] args) {
        System.out.println("Main thread starts running!");
        MyAdvancedThread mt = new MyAdvancedThread("Child Thread #1");
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
}
