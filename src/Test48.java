import java.io.*;

/**
 * Created by hzlichaolin on 2016/8/30.
 */
public class Test48 {
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            new SingletonGetter().start();
        }
        System.out.println("let's see the result of unserialize");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myObject.txt"));
            oos.writeObject(MyObject.getSingleton());
            oos.close();
            ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("myObject.txt"));
            System.out.println(((MyObject)ooi.readObject()).hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static enum MyObject{
        singtonInstance;
        private static final long serialVersionUID = 889L;
        public static MyObject getSingleton(){
            return singtonInstance;
        }
    }

    static class SingletonGetter extends Thread{
        @Override
        public void run() {
            System.out.println(MyObject.getSingleton().hashCode());
        }
    }
}
