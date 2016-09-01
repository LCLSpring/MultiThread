/**
 * Created by hzlichaolin on 2016/8/30.
 */
public class Test50 {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("my thread group");
        new Thread(group,new MyTask()).start();
        new Thread(group,new MyTask()).start();
        System.out.println("alive threads " + group.activeCount());
        System.out.println("group name " + group.getName());
    }

    static class MyTask implements Runnable{

        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
