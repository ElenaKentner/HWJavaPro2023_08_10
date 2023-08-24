package homeWork_2023_08_10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordStorageTest {

    private PasswordStorage passwordStorage = new PasswordStorage();

    @Test
    public void testCheckPasswordCorrect() {
        assertTrue(passwordStorage.checkPassword("user123", "User123"));
    }

    @Test
    public void testCheckPasswordIncorrect() {
        assertFalse(passwordStorage.checkPassword("user123", "wrongPassword"));
    }

    @Test
    public void testCheckPasswordNonExistentUser() {
        assertFalse(passwordStorage.checkPassword("nonexistent", "password"));
    }
}