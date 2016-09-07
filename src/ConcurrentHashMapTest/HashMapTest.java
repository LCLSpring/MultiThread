package ConcurrentHashMapTest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by hzlichaolin on 2016/9/4.
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        for (int i = 0; i < 100000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 200000; j++) {
                        map.put(UUID.randomUUID().toString(),"kello");
                    }
                    System.out.println(map);
                }
            }).start();
        }
    }
}
