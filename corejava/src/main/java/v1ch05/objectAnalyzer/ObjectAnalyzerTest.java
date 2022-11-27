package v1ch05.objectAnalyzer;

import java.util.ArrayList;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/11/27 16:45
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) throws IllegalAccessException {
        var squares = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            squares.add(i * i);
            System.out.println(new ObjectAnalyzer().toString(squares));
        }
    }
}
