package guru.qa.model;

public class User {

  private final String username;
  private final String password;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public boolean isSameUser(String username, String password) {
    return this.username.equals(username) && this.password.equals(password);
  }

  @Override
  public String toString() {
    return "User with username: " + username + " and password: " + password;
  }
}
