package dao;

public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;


    // Default Constructor
    public User() {}

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String nom) { this.name = nom; }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}