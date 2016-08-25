/**
 * Created by hzlichaolin on 2016/8/22.
 */
public class Test11 {
    public static void main(String[] args) {
        try {
            Thread t = new Thread(new Runnable() {
                public void run() {
                    try {
                        System.out.println("run begin");
                        Thread.sleep(200000);
                        System.out.println("run end");
                    } catch (InterruptedException e) {
                        System.out.println("catch in run thread  " + Thread.currentThread().isInterrupted());
                    }
                }
            });
            t.start();
            t.sleep(200);
            t.interrupt();
        } catch (InterruptedException e) {
            System.out.println("catch in main");
        }
    }
}
