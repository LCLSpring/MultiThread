package ConcurrentHashMapTest;

import java.util.Scanner;

/**
 * Created by hzlichaolin on 2016/9/5.
 */
public class Calculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int[] sumArr = new int[input-2];
        for (int i = 0; i < sumArr.length; i++) {
            sumArr[i] = 0;
        }
        for (int i = 2; i <input ; i++) {
            int temp = input;
            while (temp > 0){
                sumArr[i-2]+= temp%i;
                temp = temp/i;
            }
        }
        int result = 0;
        for (int i = 0; i < sumArr.length; i++) {
            result+=sumArr[i];
        }
        int length = sumArr.length;
        for (int i = length; i >= 1; i--) {
            if (result % i == 0 && length % i == 0 ){
                result = result/i;
                length = length/i;
            }
        }
        System.out.println(result+"/"+length);
    }
}
