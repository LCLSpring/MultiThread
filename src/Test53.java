/**
 * Created by hzlichaolin on 2016/8/30.
 */
public class Test53 {
    public static void main(String[] args) {
        Object lock = new Object();
        new SerializeTask(lock,"A",0).start();
        new SerializeTask(lock,"B",1).start();
        new SerializeTask(lock,"C",2).start();
    }
    static class SerializeTask extends Thread{
        private Object lock;
        private String name;
        private int count;
        private static int addNumber = 0;

        @Override
        public void run() {
            try {
                synchronized (lock){
                    while (true){
                        if (addNumber % 3 == count){
                            System.out.println(name);
                            Thread.sleep(3000);
                            lock.notifyAll();
                            addNumber++;
                        }else {
                            lock.wait();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public SerializeTask(Object lock, String name, int count) {
            this.lock = lock;
            this.name = name;
            this.count = count;
        }
    }
}
