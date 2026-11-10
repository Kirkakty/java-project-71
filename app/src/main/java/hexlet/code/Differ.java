package hexlet.code;

import static hexlet.code.Format.Stylish.stylishDiff;
import static hexlet.code.Format.jsonFormat.diffToString;
import static hexlet.code.Format.plain.plainDiff;
import static hexlet.code.Parser.getData;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format)
            throws Exception {
        var firstFile = getData(filePath1);
        var secondFile = getData(filePath2);
        switch (format) {
            case "plain":
                return plainDiff(firstFile, secondFile);
            case "json":
                return diffToString(firstFile, secondFile);
            default:
                return stylishDiff(firstFile, secondFile);
        }
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
