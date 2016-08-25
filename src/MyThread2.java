/**
 * Created by hzlichaolin on 2016/8/21.
 */
public class MyThread2 extends Thread {
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random()*1000);
                Thread.sleep(time);
                System.out.println(Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
