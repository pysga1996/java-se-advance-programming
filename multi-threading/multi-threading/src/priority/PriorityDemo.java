package priority;

public class PriorityDemo {
    public static void main(String[] args) {
        Priority mt1 = new Priority("High Priority Thread");
        Priority mt2 = new Priority("Low Priority Thread");
        mt1.thrd.setPriority(Thread.NORM_PRIORITY + 2);
        mt2.thrd.setPriority(Thread.NORM_PRIORITY - 2);
        mt1.thrd.start();
        mt2.thrd.start();
        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException ex) {
            System.out.println("Main thread has been interrupted!");
        }
        System.out.println("\nHigh Priority Thread has count to " + mt1.count);
        System.out.println("\nHigh Priority Thread has count to " + mt2.count);
    }
}
