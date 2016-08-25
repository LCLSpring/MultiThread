/**
 * Created by hzlichaolin on 2016/8/22.
 */
public class Test8 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    System.out.println(i);
                }
            }
        });
        System.out.println(thread.isInterrupted());
        System.out.println(thread.isInterrupted());
    }
}
