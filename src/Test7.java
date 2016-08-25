/**
 * Created by hzlichaolin on 2016/8/21.
 */
public class Test7 {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable() {
            public void run() {
                for (int i = 0; i < 500000; i++) {
                    System.out.println(i);
                }
            }
        };
        Thread thread = new Thread(r);
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        System.out.println("main end");
    }
}
