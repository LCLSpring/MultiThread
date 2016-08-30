/**
 * Created by hzlichaolin on 2016/8/28.
 */
public class Test34 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    Tool.tl1.set(i);
                    System.out.println("run1 set value " + Tool.tl1.get());
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    Tool.tl1.set(i);
                    System.out.println("run2 set value " + Tool.tl1.get());
                }
            }
        }).start();
        for (int i = 0; i < 300; i++) {
            Tool.tl1.set(i);
            System.out.println("main set value " + Tool.tl1.get());
        }
    }

    static class Tool{
        public static ThreadLocal tl1 = new ThreadLocal();
    }
}
