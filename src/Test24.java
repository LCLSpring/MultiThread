/**
 * Created by hzlichaolin on 2016/8/25.
 */
public class Test24 {
    public static void main(String[] args) throws InterruptedException {
        PrintString printString = new PrintString();
        new Thread(printString).start();
        Thread.sleep(200);
        System.out.println("I want to stop this guy");
        printString.setContinue(false);
    }

    static class PrintString implements Runnable{
        private boolean isContinue = true;

        public void setContinue(boolean aContinue) {
            isContinue = aContinue;
        }

        public void printMethod(){
            try {
                while (isContinue == true){
//                    System.out.println(Thread.currentThread().getName());
//                    Thread.sleep(1000);
//                    String s = "a ";
//                    synchronized (s){
//
//                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            printMethod();
        }
    }
}