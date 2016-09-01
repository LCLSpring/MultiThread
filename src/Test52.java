/**
 * Created by hzlichaolin on 2016/8/30.
 */
public class Test52 {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("my group");
        for (int i = 0; i < 5; i++) {
            new MyTask(group,"deadloop"+i).start();
        }
        Thread.sleep(3000);
        group.interrupt();
    }

    static class MyTask extends Thread{
        public MyTask(ThreadGroup group, String name) {
            super(group, name);
        }

        @Override
        public void run() {
            System.out.println("begin to dead loop");
            while (!this.isInterrupted()){

            }
            System.out.println("get out of the dead loop");
        }
    }
}
