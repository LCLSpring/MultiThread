/**
 * Created by hzlichaolin on 2016/8/30.
 */
public class DoubleCheckLock {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new SingletonGetter().start();
        }
    }
    static class MyObject{
        private volatile static MyObject singleton;
        public static MyObject getSingleton(){
            try {
                if (singleton == null){
                    Thread.sleep(3000);
                    synchronized (MyObject.class){
                        if (singleton == null){
                            singleton = new MyObject();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return singleton;
        }
    }

    static class SingletonGetter extends Thread{
        @Override
        public void run() {
            System.out.println(MyObject.getSingleton().hashCode());
        }
    }
}
