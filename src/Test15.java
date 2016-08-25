/**
 * Created by hzlichaolin on 2016/8/23.
 */
public class Test15 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (true){
                    if (Thread.currentThread().isInterrupted()){
                        return;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("time = " + System.currentTimeMillis() +" i = " + i++);
                }
            }
        });
        t.start();
        Thread.sleep(10);
        System.out.println("to suspend ---------------------------");
        t.suspend();
        System.out.println("--------------------------------------");
        Thread.sleep(2000);
        t.resume();
        Thread.sleep(10);
        t.interrupt();
    }
}
