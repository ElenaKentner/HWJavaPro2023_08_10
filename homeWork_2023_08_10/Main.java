package homeWork_2023_08_10;

/*
Классы:

User:

Поля:
int id
String username
String email
List<Role> roles
Методы:
getUserInfo(): Возвращает строку с информацией о пользователе.
addRole(Role role): Добавляет роль пользователю.
removeRole(Role role): Удаляет роль у пользователя.
Бизнес-логика: Класс описывает пользователя с уникальным идентификатором, именем, адресом электронной почты
и списком ролей. Пользователь может иметь несколько ролей.
Role:

Поля:
int id
String roleName
String description
Методы:
getRoleInfo(): Возвращает строку с информацией о роли.
setDescription(String description): Устанавливает описание роли.
Бизнес-логика: Класс описывает роль с уникальным идентификатором, названием и описанием.
AuthenticationService:

Поля:
UserDatabase userDatabase
Методы:
authenticate(String username, String password): Проверяет аутентификацию пользователя.
grantAccess(User user): Предоставляет доступ пользователю.
revokeAccess(User user): Отзывает доступ у пользователя.
Бизнес-логика: Класс предоставляет методы для аутентификации пользователей, предоставления и отзыва доступа.
UserDatabase:

Поля:
List<User> users
Методы:
getUserById(int id): Возвращает пользователя по его идентификатору.
getUserByUsername(String username): Возвращает пользователя по имени пользователя.
addUser(User user): Добавляет нового пользователя в базу данных.
Бизнес-логика: Класс управляет хранением и доступом к пользователям.
 */
public class Main {
    public static void main(String[] args) {
        Role adminRole = new Role(1, "Admin");
        Role userRole = new Role(2, "User");
        User user1 = new User(1, "user123", "user@example.com");
        user1.addRole(userRole);
        User user2 = new User(2, "admin456", "admin@example.com");
        user2.addRole(adminRole);

        UserDatabase userDatabase = new UserDatabase();
        userDatabase.addUser(user1);
        userDatabase.addUser(user2);

        PasswordStorage passwordStorage = new PasswordStorage();
        AuthenticationService authenticationService = new AuthenticationService(userDatabase, passwordStorage);

        boolean isAuthenticated = authenticationService.authenticate("user123", "password123");
        if (isAuthenticated) {
            System.out.println("Authentication successful");
        } else {
            System.out.println("Authentication failed");
        }

        User foundUser = userDatabase.getUserByUsername("user123");
        if (foundUser != null) {
            System.out.println(foundUser.getUserInfo());

            authenticationService.grantAccess(foundUser);
            System.out.println("Access granted:");
            System.out.println(foundUser.getUserInfo());

            authenticationService.revokeAccess(foundUser);
            System.out.println("Access revoked:");
            System.out.println(foundUser.getUserInfo());
        } else {
            System.out.println("User not found");
        }
    }
}

