import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by hzlichaolin on 2016/9/1.
 */
public class Test57 {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] infos = threadMXBean.dumpAllThreads(false,false);
        for (ThreadInfo info : infos) {
            System.out.println(info.getThreadId() + ":" + info.getThreadName());
        }
    }
}
