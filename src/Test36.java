import java.util.Date;

/**
 * Created by hzlichaolin on 2016/8/28.
 */
public class Test36 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("main get value " + Tool.inheritableThreadLocal.get());
            Thread.sleep(100);
        }
        Thread.sleep(5000);
        new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("run get value " + Tool.inheritableThreadLocal.get());
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static class Tool{
        public static InheritableThreadLocal<Date> inheritableThreadLocal = new InheritableThreadLocal<Date>(){
            @Override
            protected Date initialValue() {
                return new Date();
            }
        };
    }
}
