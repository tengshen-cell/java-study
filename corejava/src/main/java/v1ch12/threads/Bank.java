package v1ch12.threads;

import java.util.Arrays;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/11/28 18:44
 */
public class Bank {
    private final double[] accounts;

    public Bank(int n, double initialBalance) {
       accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public void transfer(int from, int to, double amount) {
        if (accounts[from] < amount) {
            return;
        }
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
    }

    public double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) {
            sum += 0;
        }
        return sum;
    }

    public int size() {
        return accounts.length;
    }
}
