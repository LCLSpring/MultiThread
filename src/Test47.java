import java.io.*;

/**
 * Created by hzlichaolin on 2016/8/30.
 */
public class Test47 {
    public static void main(String[] args) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myObject.txt"));
            MyObject instance1 = MyObject.getInstance();
            System.out.println(instance1.hashCode());
            oos.writeObject(instance1);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("myObject.txt"));
            MyObject instance2 = (MyObject)ooi.readObject();
            System.out.println(instance2.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class MyObject implements Serializable{
        private static final long serialVersionUID = 888L;
        private static class MyObjectHandler{
            private static MyObject myObject= new MyObject();
        }
        public static MyObject getInstance(){
            return MyObjectHandler.myObject;
        }
        protected Object readResolve() throws ObjectStreamException{
            System.out.println("call readResolve method");
            return MyObjectHandler.myObject;
        }
    }
}
