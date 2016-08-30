import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hzlichaolin on 2016/8/29.
 */
public class Test40 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        final Service service = new Service(lock,condition1,condition2);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    service.set();
                }
            }).start();
            new Thread(new Runnable() {
                public void run() {
                    service.get();
                }
            }).start();
        }
    }

    static class Service{
        private ReentrantLock lock;
        private Condition condition1;
        private Condition condition2;
        private boolean hasValue = false;

        public Service(ReentrantLock lock, Condition condition1, Condition condition2) {
            this.lock = lock;
            this.condition1 = condition1;
            this.condition2 = condition2;
        }

        public void set(){
            try {
                lock.lock();
                while (hasValue == true){
                    condition1.await();
                }
                System.out.println("I set value");
                hasValue = true;
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        public void get(){
            try {
                lock.lock();
                while (hasValue == false){
                    condition2.await();
                }
                System.out.println("I get value");
                hasValue = false;
                condition1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
