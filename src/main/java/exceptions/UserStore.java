package exceptions;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User findUser = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                findUser = user;
                break;
            }
        }
        if (findUser == null) {
            throw new UserNotFoundException("User not found");
        }
        return findUser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User isn't valid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Olga Remneva", true)
        };
        try {
            User user = findUser(users, "Olga Remneva");
            if (validate(user)) {
                System.out.println("This user has an access");
            }

        } catch (UserInvalidException ie) {
            ie.printStackTrace();
        } catch (UserNotFoundException nfe) {
            nfe.printStackTrace();
        }
    }
}
