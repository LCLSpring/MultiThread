import java.util.Date;

/**
 * Created by hzlichaolin on 2016/8/28.
 */
public class Test37 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("main get " + Tool.inheritableThreadLocal.get());
            Thread.sleep(100);
        }
        Thread.sleep(5000);
        new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("run get " + Tool.inheritableThreadLocal.get());
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static class Tool{
        public static InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal(){
            @Override
            protected Object initialValue() {
                return new Date().getTime();
            }

            @Override
            protected Object childValue(Object parentValue) {
                return parentValue + " I do something in child Thread";
            }
        };
    }
}
