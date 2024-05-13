package guru.qa.repository;

import com.opencsv.CSVReader;
import guru.qa.model.User;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileUserRepository implements UserRepository {
    private final Path pathToFile;

    public FileUserRepository(Path pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public List<User> findAll() throws Exception {
        List<String[]> users;
        try (InputStream is = Files.newInputStream(pathToFile);
             CSVReader reader = new CSVReader(new InputStreamReader(is))) {
            users = reader.readAll();
        }
        return users.stream()
                .map(array -> new User(array[0], array[1], array[2]))
                .toList();
    }
}
