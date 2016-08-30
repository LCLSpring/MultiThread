import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzlichaolin on 2016/8/26.
 */
public class Test27 {
    public static void main(String[] args) {
        final List<String> list = new ArrayList<String>();
        new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        list.add("hello");
                        System.out.println(i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                try {
                    while (true){
                        if (list.size() == 5){
                            System.out.println("time to wake up");
                            throw new InterruptedException();
                        }
                        Thread.sleep(3000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
