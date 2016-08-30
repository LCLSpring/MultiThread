import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by hzlichaolin on 2016/8/27.
 */
public class Test32 {
    public static void main(String[] args) throws IOException {
        final PipedInputStream pipedInputStream = new PipedInputStream();
        final PipedOutputStream pipedOutputStream = new PipedOutputStream();
        pipedOutputStream.connect(pipedInputStream);
        new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("write data :");
                    for (int i = 0; i < 300; i++) {
                        pipedOutputStream.write((""+i).getBytes());
                    }
                    pipedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("read data :");
                    byte[] bytes = new byte[20];
                    int readLength = pipedInputStream.read(bytes);
                    while (readLength != -1){
                        String newData = new String(bytes,0,readLength);
                        readLength = pipedInputStream.read(bytes);
                        System.out.println(newData);
                    }
                    System.out.println();
                    pipedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
