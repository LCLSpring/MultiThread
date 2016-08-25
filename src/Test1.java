/**
 * Created by hzlichaolin on 2016/8/21.
 */
public class Test1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("finish");
    }
}
