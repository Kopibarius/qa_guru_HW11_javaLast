package guru.qa.repository;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static guru.qa.Main.userRepositoryPath;

public class FileNotesRepository implements NotesRepository {

    private final Path pathToFile;

    public FileNotesRepository(Path pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public void saveNote(String note, String username) throws Exception {
        String newNote = username + "," + note + "\n";
        Files.write(pathToFile, newNote.getBytes(), StandardOpenOption.APPEND);
    }

    @Override
    public List<String> getNotesContent(String secondName) throws Exception {
        List<String[]> notes;
        List<String[]> allUsers;
        List<String> namesOfFamily;

        try (InputStream isf = Files.newInputStream(Path.of(userRepositoryPath));
             CSVReader reader = new CSVReader(new InputStreamReader(isf))) {
            allUsers = reader.readAll();
        }
        namesOfFamily = allUsers.stream()
                .filter(array -> array[2].equals(secondName))
                .map(array -> array[0])
                .toList();

        try (InputStream is = Files.newInputStream(pathToFile);
             CSVReader reader = new CSVReader(new InputStreamReader(is))) {
            notes = reader.readAll();
        }

        return notes.stream()
                .filter(array -> namesOfFamily.contains(array[0]))
                .map(array -> array[1])
                .toList();
    }
}
