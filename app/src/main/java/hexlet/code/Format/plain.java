package hexlet.code.Format;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

public class plain {
    public static String plainDiff(Map<String, Object> data1, Map<String, Object> data2) {
        TreeSet<String> keys = new TreeSet<>();
        keys.addAll(data1.keySet());
        keys.addAll(data2.keySet());
        StringBuilder sb = new StringBuilder("");
        for (String key : keys) {
            boolean containFirst = data1.containsKey(key);
            boolean containSecond = data2.containsKey(key);
            if (containFirst && containSecond) {
                Object v1 = data1.get(key);
                Object v2 = data2.get(key);
                if (Objects.equals(v1, v2)) {
                    sb.append("");
                } else {
                    sb.append("Property '")
                            .append(key)
                            .append("' was updated. From ")
                            .append(formatValue(v1))
                            .append(" to ")
                            .append(formatValue(v2))
                            .append("\n");
                }
            } else if (containFirst) {
                sb.append("Property '").append(key).append("' was removed").append("\n");
            } else {
                sb.append("Property '")
                        .append(key)
                        .append("' was added with value: ")
                        .append(formatValue(data2.get(key)))
                        .append("\n");
            }
        }
        if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == '\n') {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    private static String formatValue(Object value) {
        if (value == null) return "null";
        if (value instanceof String) return "'" + value + "'";
        if (value instanceof List<?> || value instanceof Map<?, ?>) return "[complex value]";
        return String.valueOf(value);
    }
}
