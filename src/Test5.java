/**
 * Created by hzlichaolin on 2016/8/21.
 */
public class Test5 {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            private int i = 100;
            public void run() {
                System.out.println(i-- + Thread.currentThread().getName());
            }
        };
        for (int i = 0; i < 100; i++) {
            new Thread(r).start();
        }
    }
}
