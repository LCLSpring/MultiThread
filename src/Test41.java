import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by hzlichaolin on 2016/8/29.
 */
public class Test41 {
    public static void main(String[] args) {
        final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReadThread t1 = new ReadThread();
        t1.setReadWriteLock(readWriteLock);
        ReadThread t2 = new ReadThread();
        t2.setReadWriteLock(readWriteLock);
        t1.start();
        t2.start();
    }

    static class ReadThread extends Thread{
        private ReentrantReadWriteLock readWriteLock;

        public void setReadWriteLock(ReentrantReadWriteLock readWriteLock) {
            this.readWriteLock = readWriteLock;
        }

        @Override
        public void run() {
            try {
                readWriteLock.readLock().lock();
                System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
