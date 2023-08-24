package homeWork_2023_08_10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationServiceTest {
    private UserDatabase userDatabase;
    private PasswordStorage passwordStorage;
    private AuthenticationService authenticationService;

    @BeforeEach
    public void setUp() {
        userDatabase = new UserDatabase();
        User user1 = new User(1, "user123", "user@example.com");
        userDatabase.addUser(user1);

        passwordStorage = new PasswordStorage();
        authenticationService = new AuthenticationService(userDatabase, passwordStorage);
    }

    @Test
    public void testAuthenticateCorrect() {
        assertTrue(authenticationService.authenticate("user123", "User123"));
    }

    @Test
    public void testAuthenticateIncorrectPassword() {
        assertFalse(authenticationService.authenticate("user123", "wrongPassword"));
    }

    @Test
    public void testAuthenticateNonExistentUser() {
        assertFalse(authenticationService.authenticate("nonexistent", "password"));
    }
}