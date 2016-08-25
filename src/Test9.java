/**
 * Created by hzlichaolin on 2016/8/22.
 */
public class Test9 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 50000000; i++) {
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("interrupt!!!!!!!!");
                        break;
                    }
                    System.out.println(i);
                }
            }
        });
        t.start();
        t.sleep(1000);
        t.interrupt();
    }
}
