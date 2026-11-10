package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Parser {
    public static Map<String, Object> getData(String fileName) throws Exception {
        String content = readFile(fileName);
        String ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
        return parse(content, ext);
    }

    private static String readFile(String fileName) throws Exception {
        return Files.readString(Path.of(fileName));
    }

    private static Map<String, Object> parse(String content, String format) throws Exception {
        ObjectMapper mapper;
        switch (format) {
            case "json":
                mapper = new ObjectMapper();
                break;
            case "yml":
            case "yaml":
                mapper = new YAMLMapper();
                break;
            default:
                throw new IllegalArgumentException("Unsupported format: " + format);
        }
        return mapper.readValue(content, new TypeReference<Map<String, Object>>() {});
    }
}
