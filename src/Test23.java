/**
 * Created by hzlichaolin on 2016/8/25.
 */
public class Test23 {
    public static void main(String[] args) throws InterruptedException {
        PrintString p = new PrintString();
        p.printMethod();
        Thread.sleep(2000);
        p.setContinue(false);
    }

    static class PrintString{
        private volatile boolean isContinue = true;

        public void setContinue(boolean aContinue) {
            isContinue = aContinue;
        }

        public void printMethod() throws InterruptedException {
            while (isContinue){
                System.out.println("thread name = " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        }
    }
}
