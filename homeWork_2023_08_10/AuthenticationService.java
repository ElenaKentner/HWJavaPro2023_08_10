package homeWork_2023_08_10;

public class AuthenticationService {
    private final UserDatabase userDatabase;
    private final PasswordStorage passwordStorage;

    public AuthenticationService(UserDatabase userDatabase, PasswordStorage passwordStorage) {
        this.userDatabase = userDatabase;
        this.passwordStorage = passwordStorage;
    }

    public boolean authenticate(String username, String password) {
            User user = userDatabase.getUserByUsername(username);
            if (user != null) {
                return passwordStorage.checkPassword(username, password);
            }
            return false;
        }


    public void grantAccess(User user) {
        Role authorizedRole = new Role(3, "Authorized");
        user.addRole(authorizedRole);
    }

    public void revokeAccess(User user) {
        Role authorizedRole = new Role(3, "Authorized");
        user.removeRole(authorizedRole);
    }
}
