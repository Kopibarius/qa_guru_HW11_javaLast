package guru.qa.model;

public class User {

  private final String username;
  private final String password;
  private final String secondName;

  public User(String username, String password, String secondName) {
    this.username = username;
    this.password = password;
    this.secondName = secondName;
  }

  public String getUsername() {
    return username;
  }

  public String getUserSecondName() {
    return secondName;
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
