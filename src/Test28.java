/**
 * Created by hzlichaolin on 2016/8/26.
 */
public class Test28 {
    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
        new Thread(new Runnable() {
            public void run() {
                try {
                    synchronized (lock){
                        System.out.println("begin to wait at " + System.currentTimeMillis());
                        lock.wait();
                        System.out.println("continue at " + System.currentTimeMillis());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(3000);
        new Thread(new Runnable() {
            public void run() {
                synchronized (lock){
                    System.out.println("begin to notify at " + System.currentTimeMillis());
                    lock.notify();
                    System.out.println("finish notify " + System.currentTimeMillis());
                }
            }
        }).start();
    }
}
