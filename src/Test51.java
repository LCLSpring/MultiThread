/**
 * Created by hzlichaolin on 2016/8/30.
 */
public class Test51 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
    }
}
