import java.util.concurrent.CountDownLatch;

/**
 * Created by hzlichaolin on 2016/8/31.
 */
public class Test56 {
    public static volatile int lock = 0;
    public static int sum = 0;
    public static CountDownLatch countDownLatch = new CountDownLatch(100);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        lock = 1;
                        sum++;
                        int i = lock;
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println(sum);
    }
}
