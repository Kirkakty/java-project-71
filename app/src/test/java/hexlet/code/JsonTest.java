package hexlet.code;

import static hexlet.code.Differ.generate;
import static hexlet.code.TestUtils.expectedFile;
import static hexlet.code.TestUtils.getAbsolutePath;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class JsonTest {
    @Test
    public void jsonFilesTest() throws Exception {
        String expected = expectedFile("stylishResultTest.txt");
        String file1 = getAbsolutePath("correctFile1.json");
        String file2 = getAbsolutePath("correctFile2.json");
        String format = "";
        String actual = generate(file1, file2, format);
        assertEquals(expected, actual);
    }

    @Test
    public void jsonPlainTest() throws Exception {
        String expected = expectedFile("JsonPlainTest.txt");
        String file1 = getAbsolutePath("correctFile1.json");
        String file2 = getAbsolutePath("correctFile2.json");
        String format = "plain";
        String actual = generate(file1, file2, format);
        assertEquals(expected, actual);
    }

    @Test
    public void YamlFilesTest() throws Exception {
        String expected = expectedFile("yamlTestResult.txt");
        String file1 = getAbsolutePath("correctFile1.yaml");
        String file2 = getAbsolutePath("correctFile2.yaml");
        String format = "";
        String actual = generate(file1, file2, format);
        assertEquals(expected, actual);
    }

    @Test
    public void YamlPlainTest() throws Exception {
        String expected = expectedFile("yamlPlainTest.txt");
        String file1 = getAbsolutePath("correctFile1.yaml");
        String file2 = getAbsolutePath("correctFile2.yaml");
        String format = "plain";
        String actual = generate(file1, file2, format);
        assertEquals(expected, actual);
    }
}
