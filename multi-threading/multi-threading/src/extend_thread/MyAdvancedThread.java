package extend_thread;

public class MyAdvancedThread extends Thread {
    public MyAdvancedThread(String name) {
        super(name);
        start();
    }

    @Override
    public void run() {
        System.out.println(getName() + " start running!");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println(getName() + " is couting to" + count + "!");
            }
        } catch (InterruptedException ex) {
            System.out.println(getName() + " has been interrupted!");
        }
        System.out.println(getName() + " has stopped!");
    }
}
