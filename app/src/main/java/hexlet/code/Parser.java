package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Parser {
    public static Map<String, Object> getData(String fileName) throws Exception {
        String content = readFile(fileName);
        return parse(content);
    }

    private static String readFile(String fileName) throws Exception {
        return Files.readString(Path.of(fileName));
    }

    private static Map<String, Object> parse(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, new TypeReference<Map<String, Object>>() {});
    }
}
