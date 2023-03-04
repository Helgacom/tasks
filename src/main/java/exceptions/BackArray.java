package exceptions;

import java.util.Arrays;

public class BackArray {
    public static void main(String[] args) {
        String[] names = {"Petr", "Ivan", "Nik", "Vasya"};
        int middle = names.length / 2;
        for (int index = 0; index < middle; index++) {
            String temp = names[index];
            /* was:
            names[index] = names[names.length - index];
            names[names.length - index] = temp;
            it throws RTE (unchecked) - ArrayIndexOutOfBoundException: Index 4 out of bounds for length 4 */
            names[index] = names[names.length - index - 1];
            names[names.length - index - 1] = temp;
        }
        System.out.println(Arrays.toString(names));
    }
}
