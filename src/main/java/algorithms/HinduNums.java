package algorithms;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Stream.of;

public class HinduNums {
    public static int findDiffMaxAndMin(int num) {
        var str = valueOf(num).split("");
        var min = of(str)
                .sorted()
                .collect(joining());
        var max = of(str)
                .sorted(reverseOrder())
                .collect(joining());
        return parseInt(max) - parseInt(min);
    }

    public static void main(String[] args) {
        int num = 6174;
        System.out.println(findDiffMaxAndMin(num));
    }
}
