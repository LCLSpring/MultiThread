/**
 * Created by hzlichaolin on 2016/8/30.
 */
public class Test49 {
    public static void main(String[] args) throws InterruptedException {
        StateThread thread = new StateThread();
        System.out.println("thread now is at state: " + thread.getState());
        thread.start();
        System.out.println("thread now is at state: " + thread.getState());
        Thread.sleep(3000);
        System.out.println(thread.getState());
    }

    static class StateThread extends Thread{
        public StateThread() {
            System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getState());
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getState());
        }
    }
}
