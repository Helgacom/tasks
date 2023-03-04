package algorithms;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsInString {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        Arrays.sort(words, Collections.reverseOrder());

        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String s = "It is  snowing  today";
        System.out.println(reverseWords(s));
    }
}
