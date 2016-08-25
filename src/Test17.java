import java.util.Random;

/**
 * Created by hzlichaolin on 2016/8/23.
 */
public class Test17 {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            MyThread t1 = new MyThread();
            MyThread t2 = new MyThread();
            t1.setPriority(1);
            t1.setName("low");
            t2.setPriority(10);
            t2.setName("high");
            t1.start();
            t2.start();
        }
    }

    static class MyThread extends Thread{

        public void run() {
            long begin = System.currentTimeMillis();
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 50000; j++) {
                    Random random = new Random();
                    random.nextInt();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println((end - begin) + Thread.currentThread().getName());
        }
    }
}
