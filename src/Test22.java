/**
 * Created by hzlichaolin on 2016/8/24.
 */
public class Test22 {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        MyThread t1 = new MyThread();
        t1.setName("a");
        t1.setService(service);
        MyThread t2 = new MyThread();
        t2.setName("b");
        t2.setService(service);
        t1.start();
//        Thread.sleep(20);
        t2.start();
    }

    static class MyThread extends Thread{
        private Service service;

        public void setService(Service service) {
            this.service = service;
        }

        public void run() {
            service.testMethod();
        }
    }

    static class Service{
        private String lock = "123";
        public void testMethod(){
            try {
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName() + " begin at " + System.currentTimeMillis());
                    lock = "456";
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " end at " + System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
