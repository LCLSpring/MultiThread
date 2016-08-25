/**
 * Created by hzlichaolin on 2016/8/21.
 */
public class Test4 {
    public static void main(String[] args) {
        try {
            throw new Exception("experience exception");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("I can run after try catch block");
    }
}
