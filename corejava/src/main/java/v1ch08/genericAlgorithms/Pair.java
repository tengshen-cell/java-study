package v1ch08.genericAlgorithms;

import java.util.function.Supplier;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/11/28 14:59
 */
public class Pair<T> {
    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public static <T> Pair<T> makePair(Supplier<T> constr) {
        return new Pair<>(constr.get(), constr.get());
    }

    public static <T> Pair<T> makePair(Class<T> cl) {
        try {
            return new Pair<>(cl.getConstructor().newInstance(), cl.getConstructor().newInstance());
        } catch (Exception e) {
            return null;
        }
    }
}
