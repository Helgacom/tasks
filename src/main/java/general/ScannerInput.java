package general;

import java.util.Scanner;

public class ScannerInput {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input a number: ");
        int num = in.nextInt();
        System.out.println(Factorial.factorial(num));

        Scanner inStr = new Scanner(System.in);
        System.out.println("Input name: ");
        String name = inStr.nextLine();
        System.out.println(name + " - it's the best name!");

        Scanner inFloat = new Scanner(System.in);
        System.out.print("Input height: ");
        float height = inFloat.nextFloat();
        System.out.println(height + " - You're in great shape!");

        Scanner expression = new Scanner(System.in);
        System.out.println("Input number: ");
        String str = expression.nextLine();
        System.out.println("2" + str + "---3" + str + "---4" + str);
    }
}
