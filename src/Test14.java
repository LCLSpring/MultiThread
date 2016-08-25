/**
 * Created by hzlichaolin on 2016/8/22.
 */
public class Test14 {
    public static void main(String[] args) throws InterruptedException {
        final SynchronizdObject object = new SynchronizdObject();
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    object.printString("b","bb");
                } catch (InterruptedException e) {
                    System.out.println("catch in run thread");
                }
            }
        });
        t.start();
        Thread.sleep(1000);
        t.stop();
        System.out.println(object.getUsername() + "   " + object.getPassword());
    }
}

class SynchronizdObject{
    private String username = "a";
    private String password = "aa";

    public synchronized void printString(String username,String password) throws InterruptedException {
        this.username = username;
        Thread.sleep(200000);
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
