package general;

public class Report {
    public String generate(String name, String body) {
        return name + System.lineSeparator() + body;
    }
}
