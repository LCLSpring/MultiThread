package ConcurrentHashMapTest;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by hzlichaolin on 2016/9/5.
 */
public class ElementSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String set1 = scanner.nextLine();
        String[] set1Str = set1.split(" ");
        TreeSet<Integer> result = new TreeSet<Integer>();
        for (int i = 0; i < set1Str.length; i++) {
            result.add(Integer.parseInt(set1Str[i]));
        }
        String set2 = scanner.nextLine();
        String[] set2Str = set2.split(" ");
        for (int i = 0; i < set2Str.length; i++) {
            result.add(Integer.parseInt(set2Str[i]));
        }
        for (Integer integer : result) {
            System.out.print(integer);
            System.out.print(" ");
        }
        System.out.println();
    }
}
