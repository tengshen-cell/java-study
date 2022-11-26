package v1ch05.objectAnalyzer;

import java.util.ArrayList;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/11/26 13:51
 */
public class objectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    public String toString(Object obj) {
        if (obj == null) return "null";
        if (visited.contains(obj)) return "...";
        visited.add(obj);
        Class cl = obj.getClass();
        if (cl == String.class) return (String) obj;
        if (cl.isArray()) {
            String r = cl.getComponentType() + "[]{";

        }

        return null;
    }

}
