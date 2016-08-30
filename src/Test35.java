import java.util.Date;

/**
 * Created by hzlichaolin on 2016/8/28.
 */
public class Test35 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("main get " + Tool.threadLocal.get());
            Thread.sleep(100);
        }
        Thread.sleep(5000);
        new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("run get " + Tool.threadLocal.get());
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static class Tool {
        public static ThreadLocal<Date> threadLocal = new ThreadLocal<Date>(){
            @Override
            protected Date initialValue() {
                return new Date();
            }
        };
    }
}
