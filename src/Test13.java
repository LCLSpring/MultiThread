/**
 * Created by hzlichaolin on 2016/8/22.
 */
public class Test13 {
    public static void main(String[] args) {
        try {
            Thread t = new Thread(new Runnable() {
                public void run() {
                    try {
                        int i = 0;
                        while (true){
                            System.out.println(i++);
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        System.out.println("catch in run thread");
                    }
                }
            });
            t.start();
            t.sleep(2000);
            t.stop();
        } catch (InterruptedException e) {
            System.out.println("catch in main thread");
        }
    }
}
