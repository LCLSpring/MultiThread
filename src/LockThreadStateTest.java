import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hzlichaolin on 2016/9/3.
 */
public class LockThreadStateTest {
    public static void main(String[] args) {
        ReentrantLock lock1 = new ReentrantLock();
        Object lock2 = new Object();
        for (int i = 0; i < 2; i++) {
            new LockThread1(lock1).start();
            new LockThread2(lock2).start();
        }
    }

    static class LockThread1 extends Thread{
        private ReentrantLock lock;

        public LockThread1(ReentrantLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("I get the lock");
                while (true){

                }
            }finally {
                lock.unlock();
            }
        }
    }

    static class LockThread2 extends Thread{
        private Object lock;

        public LockThread2(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock){
                System.out.println("I get the lock");
                while (true){

                }
            }
        }
    }
}
