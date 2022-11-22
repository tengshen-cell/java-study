package v1ch03.BigIntegerTest;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.print("what is the highest number you can draw");
        BigInteger n = in.nextBigInteger();

        BigInteger lotteryOdds = BigInteger.ONE;
        for (int i = 1; i <= k; i++) {
            lotteryOdds = lotteryOdds.multiply(n.subtract(BigInteger.valueOf(i - 1))).divide(BigInteger.valueOf(i));
            System.out.printf("Your odds are 1 in %s. Good lick!%n", lotteryOdds);
        }
    }
}
