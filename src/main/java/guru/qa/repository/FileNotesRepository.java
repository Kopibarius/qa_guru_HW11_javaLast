package guru.qa.repository;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileNotesRepository implements NotesRepository {

  private final Path pathToFile;

  public FileNotesRepository(Path pathToFile) {
    this.pathToFile = pathToFile;
  }

  @Override
  public void saveNote(String note, String username) throws Exception {
    Files.write(pathToFile, (username + "," + note).getBytes());
  }

  @Override
  public List<String> getNotesContent(String username) throws Exception {
    List<String[]> notes;
    try (InputStream is = Files.newInputStream(pathToFile);
         CSVReader reader = new CSVReader(new InputStreamReader(is))) {
      notes = reader.readAll();
    }
    return notes.stream()
        .filter(array -> array[0].equals(username))
        .map(array -> array[1])
        .toList();
  }
}
