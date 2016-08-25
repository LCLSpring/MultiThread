/**
 * Created by hzlichaolin on 2016/8/23.
 */
public class Test16 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                long start = System.currentTimeMillis();
                int count=0;
                for (int j = 0; j < 500000000; j++) {
                    Thread.yield();
                    count=count+j;
                }
                long end = System.currentTimeMillis();
                System.out.println(end-start);
            }
        });
        t.start();
    }
}
