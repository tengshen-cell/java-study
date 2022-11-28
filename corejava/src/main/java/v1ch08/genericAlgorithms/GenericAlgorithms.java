package v1ch08.genericAlgorithms;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.IntFunction;

/**
 * @author 滕广银
 * @description
 * @date 2022/11/28 15:09
 */
public class GenericAlgorithms {
    public static void main(String[] args) {
        Pair<String> p = Pair.makePair(String::new);
        System.out.println(p);

        p = Pair.makePair(String.class);
        System.out.println(p);

        String[] ss = ArrayAlg.minmax("Tom", "Dick", "Harry");
        System.out.println(Arrays.toString(ss));

        ss = ArrayAlg.minmax((IntFunction<String[]>) String[]::new, "Tom", "Dick", "Harry");
        System.out.println(Arrays.toString(ss));


    }
}

class ArrayAlg {
    public static <T extends Comparable> T[] minmax(IntFunction<T[]> constr, T... a) {
        T[] mm = constr.apply(2);
        T min = a[0];
        T max = a[0];

        for (int i = 1; 1 < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return mm;
    }

    public static <T extends Comparable> T[] minmax(T... a) {
        T[] mm = (T[]) Array.newInstance(a.getClass().getComponentType(), 2);
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return mm;
    }
}
