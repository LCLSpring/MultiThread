/**
 * Created by hzlichaolin on 2016/8/25.
 */
public class Test25 {
    public static void main(String[] args) throws InterruptedException {
        RunThread runThread = new RunThread();
        runThread.start();
        Thread.sleep(50);
        runThread.setRunning(false);
        System.out.println("I have try to stop this guy");
    }

    static class RunThread extends Thread{
        private boolean isRunning = true;

        public void setRunning(boolean running) {
            isRunning = running;
        }

        public void run() {
            System.out.println("go to run !!! ");
            while (isRunning){

            }
            System.out.println(" run thread has stopped");
        }
    }
}
