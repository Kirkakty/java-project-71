package hexlet.code;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.*;

public class jsonFormat {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static ArrayNode jsonDiff(Map<String, Object> file1, Map<String, Object> file2) {
        JsonNode data1 = mapper.valueToTree(file1);
        JsonNode data2 = mapper.valueToTree(file2);

        ArrayNode result = mapper.createArrayNode();
        Set<String> allKeys = new TreeSet<>();
        data1.fieldNames().forEachRemaining(allKeys::add);
        data2.fieldNames().forEachRemaining(allKeys::add);

        for (String key : allKeys) {
            JsonNode v1 = data1.get(key);
            JsonNode v2 = data2.get(key);

            ObjectNode entry = mapper.createObjectNode();
            entry.put("name", key);

            if (v1 == null) {
                entry.put("Status", "add");
                entry.set("value1", v2);
            } else if (v2 == null) {
                entry.put("Status", "removed");
                entry.set("value1", v1);
            } else if (v1.equals(v2)) {
                entry.put("Status", "unchange");
                entry.set("value", v1);
            } else {
                entry.put("Status", "update");
                entry.set("value1", v1);
                entry.set("value2", v2);
            }
            result.add(entry);
        }
        return result;
    }

    public static String diffToString(Map<String, Object> map1, Map<String, Object> map2) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonDiff(map1, map2));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
