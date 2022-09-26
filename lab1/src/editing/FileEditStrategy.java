package editing;

import java.nio.file.Path;

public interface FileEditStrategy extends Runnable {
    void edit(Path path);

    Path getPath();

    @Override
    default void run() {
        edit(getPath());
    }
}
