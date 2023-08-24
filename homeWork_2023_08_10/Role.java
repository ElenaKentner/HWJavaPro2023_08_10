package homeWork_2023_08_10;

public class Role {
    private final int id;
    private final String roleName;
    private String description;

    public Role(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
        this.description = "";
    }

    public String getRoleInfo() {
        return "Role ID: " + id + ", Role Name: " + roleName + ", Description: " + description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
