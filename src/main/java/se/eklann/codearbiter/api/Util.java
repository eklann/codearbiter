package se.eklann.codearbiter.api;

import java.util.Arrays;
import org.json.simple.JSONArray;

/**
 *
 * @author eklann
 */
public class Util {
    public static String[] getNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants())
                .map(Enum::name).toArray(String[]::new);
    }
    
    public static <E extends Enum> E getEnumValue(Class<E> type, String name) {
        return (E)E.valueOf(type, name);
    }
    
    public static String arrayToJson(String[] data) {
        JSONArray json = new JSONArray();
        json.addAll(Arrays.asList(data));
        return json.toJSONString();
    }
}
