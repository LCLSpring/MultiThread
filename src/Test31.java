import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzlichaolin on 2016/8/27.
 */
public class Test31 {
    public static void main(String[] args) {
        final List values = new ArrayList();
        final Object lock = new Object();
        new Thread(new Runnable() {
            public void run() {
                while (true){
                    try {
                        synchronized (lock){
                            if (0 == values.size()){
                                lock.wait();
                            }
                            System.out.println("get value " + values);
                            values.remove(0);
                            lock.notify();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                while (true){
                    try {
                        synchronized (lock){
                            if (1 == values.size()){
                                lock.wait();
                            }
                            values.add(System.currentTimeMillis() + "_" + System.nanoTime());
                            System.out.println("set value " + values.get(0));
                            lock.notify();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
