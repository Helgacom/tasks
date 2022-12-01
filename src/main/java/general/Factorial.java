package general;

public class Factorial {
    static int factorial(int x) {
        int rsl = 1;
        for (int i = 1; i <= x; i++) {
            rsl *= i;
        }
        return rsl;
    }

    public static void main(String[] args) {
        int x = 4;
        System.out.println(factorial(x));
    }
}
