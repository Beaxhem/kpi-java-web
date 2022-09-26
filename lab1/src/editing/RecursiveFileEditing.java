package editing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class RecursiveFileEditing implements Runnable {

    Path directory;

    public RecursiveFileEditing(Path directory) {
        this.directory = directory;
    }

    @Override
    public void run() {
        try (Stream<Path> stream = Files.list(directory)) {
            stream.forEach(file -> {
                if (file.toString().endsWith(".java")) {
                    new Thread(new DefaultFileEditStrategy(file)).start();
                    return;
                }
                if (Files.isDirectory(file)) {
                    new Thread(new RecursiveFileEditing(file)).start();

                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
