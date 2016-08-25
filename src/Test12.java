/**
 * Created by hzlichaolin on 2016/8/22.
 */
public class Test12 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 10000; i++) {
                        System.out.println(i);
                    }
                    System.out.println("run begin");
                    Thread.sleep(200000);
                    System.out.println("run end");
                } catch (InterruptedException e) {
                    System.out.println("catch in run thread");
                }
            }
        });
        t.start();
        t.interrupt();
        System.out.println("main end");
    }
}
