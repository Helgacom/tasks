package algorithms;

import java.util.*;

public class RemoveDuplicates {
    public static int[] removeDups(int[] nums) {
        return Arrays.stream(nums). distinct(). toArray();
    }

    public static String[] removeDups(String[] str) {
        return Arrays.asList(str).stream().distinct().toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] str = new String[]{"one", "two", "one"};
        int[] arr = {2, 4, 1, 2, 1, 2, 4, 5};
        String[] rsl = removeDups(str);
        int[] rsl1 = removeDups(arr);
        System.out.println(rsl.length);
        System.out.println(rsl[0]);
        System.out.println(rsl[1]);
        System.out.println(rsl1.length);
    }
}
