package exceptions;

public class JdbcConfig {
    public static void load(String url) throws UserInputEx {
        if (url == null) {
            throw new UserInputEx("Url could not be null");
        }
        /*load jdbc*/
    }

    public static void main(String[] args) {
        try{
            load("jdbc://localhost:8080");
        } catch (UserInputEx ex) {
            ex.printStackTrace();
        }
    }
}
