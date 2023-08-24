package homeWork_2023_08_10;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int id;
    private final String username;
    private final String email;
    private final List<Role> roles;

    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = new ArrayList<>();
    }

    public String getUserInfo() {
        StringBuilder info = new StringBuilder("User ID: " + id + ", Username: " + username + ", Email: " + email);
        info.append("\nRoles:");
        roles.stream().map(Role::getRoleInfo).forEach(roleInfo -> info.append("\n- ").append(roleInfo));
        return info.toString();
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public void removeRole(Role role) {
        roles.remove(role);
    }
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
