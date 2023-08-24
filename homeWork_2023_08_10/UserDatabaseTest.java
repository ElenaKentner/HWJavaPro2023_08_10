package homeWork_2023_08_10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDatabaseTest {

    private UserDatabase userDatabase;

    @BeforeEach
    public void setUp() {
        userDatabase = new UserDatabase();
        User user1 = new User(1, "user123", "user@example.com");
        User user2 = new User(2, "admin456", "admin@example.com");
        userDatabase.addUser(user1);
        userDatabase.addUser(user2);
    }

    @Test
    public void testGetUserByUsername() {
        User user = userDatabase.getUserByUsername("user123");
        assertNotNull(user);
        assertEquals("user123", user.getUsername());
    }

    @Test
    public void testGetUserByUsernameNonExistent() {
        User user = userDatabase.getUserByUsername("nonexistent");
        assertNull(user);
    }
}