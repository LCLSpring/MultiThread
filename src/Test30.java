import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzlichaolin on 2016/8/26.
 */
public class Test30 {
    public static void main(String[] args) throws InterruptedException {
        final List list = new ArrayList();
        SubstractTask substractTask = new SubstractTask();
        substractTask.setList(list);
        new Thread(substractTask).start();
        new Thread(substractTask).start();
        Thread.sleep(3000);
        new Thread(new Runnable() {
            public void run() {
                    synchronized (list){
                        list.add("good");
                        list.notifyAll();
                    }
            }
        }).start();
    }

    static class SubstractTask implements Runnable{
        private List list;

        public void setList(List list) {
            this.list = list;
        }

        public void run() {
            try {
                synchronized (list){
                    while (list.size() == 0){
                        System.out.println("we need to wait.....");
                        list.wait();
                        System.out.println("leave ....");
                    }
                    list.remove(0);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
