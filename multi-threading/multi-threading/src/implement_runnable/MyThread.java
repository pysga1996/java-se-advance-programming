package implement_runnable;

public class MyThread implements Runnable {
    public Thread thrd;

    public MyThread(String thrdName) {
        this.thrd = new Thread(this, thrdName);
        this.thrd.start();
    }

    @Override
    public void run() {
        System.out.println(thrd.getName() + " start running!");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println(thrd.getName() + " is couting to" + count + "!");
            }
        } catch (InterruptedException ex) {
            System.out.println(thrd.getName() + " has been interrupted!");
        }
        System.out.println(thrd.getName() + " has stopped!");
    }
}
