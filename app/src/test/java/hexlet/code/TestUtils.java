package hexlet.code;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.Files.readString;

public class TestUtils {
        public static String getAbsolutePath(String fileName) {
            Path resourceDirectory = Paths.get("src", "test", "resources", fileName);
            return resourceDirectory.toFile().getAbsolutePath();
        }

        public static String expectedFile (String filename) throws IOException {
        Path expectedFilePath = Paths.get("src","test","resources", filename);
        return readString(expectedFilePath);
        }
}
