
/**
 * Created by hzlichaolin on 2016/8/31.
 */
public class Test54 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                String name = null;
                System.out.println(name.hashCode());
            }
        });
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ":");
                e.printStackTrace();
            }
        });
        thread.start();
    }
}
