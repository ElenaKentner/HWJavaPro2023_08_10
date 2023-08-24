package homeWork_2023_08_10;

import java.util.HashMap;
import java.util.Map;

public class PasswordStorage {
    private final Map<String, String> passwordMap;

    public PasswordStorage() {
        this.passwordMap = new HashMap<>();
        passwordMap.put("user123", "User123");
        passwordMap.put("admin456", "Admin456");
    }

    public boolean checkPassword(String username, String password) {
        String storedPassword = passwordMap.get(username);
        if (storedPassword != null) {
            return storedPassword.equals(password);
        }
        return false;
    }
}
