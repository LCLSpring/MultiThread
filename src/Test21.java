/**
 * Created by hzlichaolin on 2016/8/24.
 */
public class Test21 {
    public static void main(String[] args) throws InterruptedException {
        DeathLockTask task = new DeathLockTask();
        task.setUsername("a");
        new Thread(task).start();
        Thread.sleep(100);
        task.setUsername("b");
        new Thread(task).start();
    }

    static class DeathLockTask implements Runnable{
        private String username;
        private Object lock1 = new Object();
        private Object lock2 = new Object();

        public void setUsername(String username) {
            this.username = username;
        }

        public void run() {
            if ("a".equals(username)){
                synchronized (lock1){
                    System.out.println("username = " + username);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2){
                        System.out.println("lock1 --> lock2");
                    }
                }
            }
            if ("b".equals(username)){
                synchronized (lock2){
                    System.out.println("username = " + username);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1){
                        System.out.println("lock2 --> lock1");
                    }
                }
            }
        }
    }
}
