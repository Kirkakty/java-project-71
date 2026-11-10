package hexlet.code;

import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

public class Stylish {
    public static String stylishDiff(Map<String, Object> data1, Map<String, Object> data2) {
        TreeSet<String> keys = new TreeSet<>();
        keys.addAll(data1.keySet());
        keys.addAll(data2.keySet());
        StringBuilder sb = new StringBuilder("{\n");
        for (String key : keys) {
            boolean containFirst = data1.containsKey(key);
            boolean containSecond = data2.containsKey(key);

            if (containFirst && containSecond) {
                Object v1 = data1.get(key);
                Object v2 = data2.get(key);
                if (Objects.equals(v1, v2)) {
                    sb.append("    ").append(key).append(": ").append(formatValue(v1)).append("\n");
                } else {
                    sb.append("  - ").append(key).append(": ").append(formatValue(v1)).append("\n");
                    sb.append("  + ").append(key).append(": ").append(formatValue(v2)).append("\n");
                }
            } else if (containFirst) {
                sb.append("  - ")
                        .append(key)
                        .append(": ")
                        .append(formatValue(data1.get(key)))
                        .append("\n");
            } else {
                sb.append("  + ")
                        .append(key)
                        .append(": ")
                        .append(formatValue(data2.get(key)))
                        .append("\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    private static String formatValue(Object value) {
        if (value == null) return "null";
        if (value instanceof String) return "" + value;
        return String.valueOf(value);
    }
}
