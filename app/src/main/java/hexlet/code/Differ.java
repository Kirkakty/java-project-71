package hexlet.code;

import static hexlet.code.Parser.getData;
import static hexlet.code.Stylish.stylishDiff;
import static hexlet.code.plain.plainDiff;

import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        var firstFile = getData(filePath1);
        var secondFile = getData(filePath2);
        if ("plain".equals(format)) {
            return plainDiff(firstFile, secondFile);
        } else {
            return stylishDiff(firstFile, secondFile);
        }
    }
}
