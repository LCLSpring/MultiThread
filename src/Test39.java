import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hzlichaolin on 2016/8/29.
 */
public class Test39 {
    public static void main(String[] args) throws InterruptedException {
        final ReentrantLock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        new Thread(new Runnable() {
            public void run() {
                try {
                    lock.lock();
                    System.out.println("wait at run");
                    condition.await();
                    System.out.println("quit");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();
        Thread.sleep(1000);
        System.out.println("notify him");
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
