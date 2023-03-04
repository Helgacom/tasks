package general;

public class ExamplesExc {

    public static String getMessage(String s) {
        String message;
        if (s.equals("Hello")) {
            message = "Hi";
        } else {
            throw new RuntimeException("Too much");
        }

        return message;
    }

    public static void main(String[] args) {
        String line = "Helloy";
        System.out.println(getMessage(line));
    }
}
