package hexlet.code;

import org.junit.jupiter.api.Test;

import static hexlet.code.Differ.generate;
import static hexlet.code.TestUtils.expectedFile;
import static hexlet.code.TestUtils.getAbsolutePath;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YamlTest {
    @Test
    public void YamlFilesTest() throws Exception{
        String expected = expectedFile("yamlTestResult.txt");
        String file1 = getAbsolutePath("correctFile1.yaml");
        String file2 = getAbsolutePath("correctFile2.yaml");
        String format = "";
        String actual = generate(file1, file2,format);
        assertEquals(expected, actual);
    }
    @Test
    public void YamlPlainTest() throws Exception{
        String expected = expectedFile("yamlPlainTest.txt");
        String file1 = getAbsolutePath("correctFile1.yaml");
        String file2 = getAbsolutePath("correctFile2.yaml");
        String format = "plain";
        String actual = generate(file1, file2,format);
        assertEquals(expected, actual);
    }
}
