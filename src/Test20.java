/**
 * Created by hzlichaolin on 2016/8/24.
 */
public class Test20 {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        MyThread t1 = new MyThread();
        t1.setObj(service);
        t1.setCommand("a");
        MyThread t2 = new MyThread();
        t2.setObj(service);
        t2.setCommand("b");
        t1.start();
        Thread.sleep(1000);
        t2.start();
    }

    static class MyThread extends Thread{
        private Service obj;
        private String command;

        public void setCommand(String command) {
            this.command = command;
        }

        public void setObj(Service obj) {
            this.obj = obj;
        }

        public void run() {
            obj.service(command);
        }
    }

    static class Service{
        public synchronized void service(String command){
            if ("a".equals(command)){
                System.out.println("thread " + Thread.currentThread().getName());
                int i = 1;
                while (1 == i){
                    if (("" + Math.random()).substring(0,8).equals("0.123456")){
                        Integer.parseInt("a");
                    }
                }
            }else {
                System.out.println("thread " + Thread.currentThread().getName());
            }
        }
    }
}
