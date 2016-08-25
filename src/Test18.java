/**
 * Created by hzlichaolin on 2016/8/23.
 */
public class Test18 {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setPriority(Thread.NORM_PRIORITY-3);
        t2.setPriority(Thread.NORM_PRIORITY+3);
        t1.start();
        t2.start();
        Thread.sleep(20000);
        System.out.println(t1.getCount());
        System.out.println(t2.getCount());
    }

    static class MyThread extends Thread{
        private long count;

        public long getCount() {
            return count;
        }

        public void run() {
            while (true){
                count++;
            }
        }
    }
}
