package editing;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReplace {
    Path path;
    String target;
    String replacement;

    FileReplace(Path path, String target, String replacement) {
        this.path = path;
        this.target = target;
        this.replacement = replacement;
    }

    public void replace() {
        try {
            List<String> lines = new ArrayList<String>();
            String line;
            File file = new File(path.toAbsolutePath().toString());
            FileReader reader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(reader);
            while ((line = bufReader.readLine()) != null) {
                if (line.contains(target)) {
                    String replacedLine = line.replace(target, replacement);
                    System.out.println("Replacing '" + line.toString() + "' with '" + replacedLine + "' in file: " + path);
                    line = replacedLine;
                }
                lines.add(line);
            }
            reader.close();
            bufReader.close();

            FileWriter writer = new FileWriter(file);
            BufferedWriter bufWriter = new BufferedWriter(writer);
            for (String s : lines) {
                bufWriter.write(s);
                bufWriter.write('\n');
            }
            bufWriter.flush();
            bufWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
