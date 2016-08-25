/**
 * Created by hzlichaolin on 2016/8/22.
 */
public class Test10 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 500000000; i++) {
                        if (Thread.currentThread().isInterrupted()){
                            System.out.println("interrupt !!!!");
                            throw new InterruptedException();
                        }
                    }
                    System.out.println("bad guy");
                } catch (InterruptedException e) {
                    System.out.println("thread end!!");
                }
                System.out.println("upder catch");
            }
        });
        t.start();
        Thread.sleep(50);
        t.interrupt();
    }
}
