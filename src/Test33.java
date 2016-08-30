/**
 * Created by hzlichaolin on 2016/8/28.
 */
public class Test33 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    int waitTime = (int) (Math.random()*1000);
                    System.out.println("you should wait for " + waitTime + " minute");
                    Thread.sleep(waitTime);
                    System.out.println("wait over");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        t.join();
        System.out.println("That is good");
    }
}
