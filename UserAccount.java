package petmanagementsystem;

public class UserAccount { 
    private int id;
    private String username;
    private String password;

   
    public UserAccount(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Setters and Getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void ResetPassword(String password) {
        this.password = password;
    }
}
