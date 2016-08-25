/**
 * Created by hzlichaolin on 2016/8/24.
 */
public class Test19 {
    public static void main(String[] args) {
        HasSelfPrivateNum num = new HasSelfPrivateNum();
        MyThread t1 = new MyThread();
        t1.setSelfPrivateNum(num);
        t1.setChoose("a");
        MyThread t2 = new MyThread();
        t2.setSelfPrivateNum(num);
        t2.setChoose("b");
        t1.start();
        t2.start();

    }

    static class HasSelfPrivateNum {
        private int i = 0;
        public void addI(String choose) throws InterruptedException {
            if (choose.equals("a")){
                System.out.println("set a over");
                i = 100;
                Thread.sleep(200);
                System.out.println(i);
            }else {
                System.out.println("set b over");
                i = 200;
                System.out.println(i);
            }
        }
    }

    static class MyThread extends Thread {
        private HasSelfPrivateNum selfPrivateNum;
        private String choose;

        public void setSelfPrivateNum(HasSelfPrivateNum selfPrivateNum) {
            this.selfPrivateNum = selfPrivateNum;
        }

        public void setChoose(String choose) {
            this.choose = choose;
        }

        public void run() {
            super.run();
            try {
                selfPrivateNum.addI(choose);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
