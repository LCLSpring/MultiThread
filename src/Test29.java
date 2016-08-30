/**
 * Created by hzlichaolin on 2016/8/26.
 */
public class Test29 {
    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    synchronized (lock){
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        Thread.sleep(1000);
        t.interrupt();
    }
}
