package guru.qa.front;

import guru.qa.model.User;
import guru.qa.repository.UserRepository;
import guru.qa.session.UserSession;

import javax.swing.*;
import java.util.NoSuchElementException;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class LoginFront implements FtBase {

  private final UserRepository userRepository;

  public LoginFront(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void start(UserSession userSession) throws Exception {
    String username = JOptionPane.showInputDialog("Username:");
    String password = JOptionPane.showInputDialog("Password:");
    User user = null;
    try {
      user = userRepository.findAll()
          .stream()
          .filter(u -> u.isSameUser(username, password))
          .findFirst()
          .orElseThrow();
    } catch (NoSuchElementException e) {
      JOptionPane.showMessageDialog(null, "User not found :(", "Error", ERROR_MESSAGE);
      start(userSession);
    }
    userSession.setUser(user);
  }
}
