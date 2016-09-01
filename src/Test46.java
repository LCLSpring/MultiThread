/**
 * Created by hzlichaolin on 2016/8/30.
 */
public class Test46 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new SingletonGetter().start();
        }
    }

    static class MyObject{
        private static class MyObjectHandler{
            private static MyObject myObject = new MyObject();
        }
        public static MyObject getInstance(){
            return MyObjectHandler.myObject;
        }
    }

    static class SingletonGetter extends Thread{
        @Override
        public void run() {
            System.out.println(MyObject.getInstance().hashCode());
        }
    }
}
