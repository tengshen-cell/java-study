package v1ch06.staticInnerClass;

/**
 * @author 滕广银
 * @description This program demonstrates the use of static inner classes.
 * @date 2022/11/28 9:07
 */
public class StaticInnerClassTest {

    public static void main(String[] args) {
        var values = new double[20];
        for (int i = 0; i < values.length; i++) {
            values[i] = 100 * Math.random();
        }

        ArrayAlg.Pair p = ArrayAlg.minmax(values);
        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }
}


class ArrayAlg {

    public static class Pair {
        private double first;
        private double second;

        public Pair(double f, double s) {
            first = f;
            second = s;
        }
        
        public double getFirst() {
            return first;
        }
        
        public double getSecond() {
            return second;
        }

    }


    public static Pair minmax(double[] values) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;

        for (double value : values) {
            if (min > value) min = value;
            if (max < value) max = value;
        }
        return new Pair(min, max);
    }


}
