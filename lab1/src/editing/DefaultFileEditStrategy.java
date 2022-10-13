package editing;

import java.nio.file.Path;

public class DefaultFileEditStrategy implements FileEditStrategy {

    Path path;

    public DefaultFileEditStrategy(Path path) {
        this.path = path;
    }

    @Override
    public void edit(Path path) {
        System.out.println("Found .java file: " + path);
        new FileReplace(path, "public", "protected").replace();
    }

    @Override
    public Path getPath() {
        return path;
    }
}
