package guru.qa.session;

import guru.qa.model.User;

public enum UserSession {
  INSTANCE;
  private User user;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
