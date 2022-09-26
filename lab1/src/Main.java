import editing.RecursiveFileEditing;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path dirPath = null;
        while (dirPath == null) {
            System.out.print("Input directory path to check: ");
            Path path = Paths.get(scanner.nextLine());
            if (Files.isDirectory(path)) {
                dirPath = path;
            } else {
                System.out.println("The path is not a directory. Please try again");
            }
        }

        new Thread(new RecursiveFileEditing(dirPath)).start();
    }
}
