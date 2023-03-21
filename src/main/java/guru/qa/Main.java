package guru.qa;

import guru.qa.front.Front;
import guru.qa.front.LoginFront;
import guru.qa.front.NotesFront;
import guru.qa.repository.FileNotesRepository;
import guru.qa.repository.FileUserRepository;
import guru.qa.session.UserSession;

import java.nio.file.Path;

public class Main {
  public static void main(String[] args) throws Exception {
    new Front(
        new LoginFront(
            new FileUserRepository(
                Path.of("users.csv")
            )
        ),
        new NotesFront(
            new FileNotesRepository(
                Path.of("notes.csv")
            )
        )
    ).start(UserSession.INSTANCE);
  }
}