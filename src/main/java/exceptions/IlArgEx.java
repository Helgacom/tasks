package exceptions;

public class IlArgEx {
    public static int add(int start, int finish) {
        if (start > finish) {
            throw new IllegalArgumentException("Start should be less than finish.");
        }
        int rsl = 0;
        for (int index = start; index != finish; index++) {
            rsl += index;
        }
        return rsl;
    }
        /* block without check that start > finish can fall with IllegalArgumentException
        int rsl = 0;
        for (int index = start; index != finish; index++) {
            rsl += index;
        }
        return rsl;
    }*/

    public static void main(String[] args) {
        System.out.println("Sum of 2 to 10 is : " + add(2, 10));
        System.out.println("Sum of 2 to 10 is : " + add(10, 2));
    }
}
