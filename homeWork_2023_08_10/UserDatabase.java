package homeWork_2023_08_10;

import java.util.ArrayList;
import java.util.List;

public final class UserDatabase {
    private final List<User> users;

    public UserDatabase() {
        users = new ArrayList<>();
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
