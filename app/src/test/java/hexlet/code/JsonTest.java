package hexlet.code;
import org.junit.jupiter.api.Test;

import static hexlet.code.Differ.generate;
import static hexlet.code.TestUtils.expectedFile;
import static hexlet.code.TestUtils.getAbsolutePath;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    @Test
    public void jsonFilesTest() throws Exception{
        String expected = expectedFile("stylishResultTest.txt");
        String file1 = getAbsolutePath("correctFile1.json");
        String file2 = getAbsolutePath("correctFile2.json");
        String actual = generate(file1, file2);
        assertEquals(expected, actual);
    }
}