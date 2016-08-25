/**
 * Created by hzlichaolin on 2016/8/21.
 */
public class Test2 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        myThread2.setName("freedom thread");
        myThread2.start();
        Thread.currentThread().setName("main thread");
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
