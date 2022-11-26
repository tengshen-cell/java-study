package v1ch05.reflection;

import java.util.Scanner;

/**
 * @author 滕广银
 * @description This program users reflection to print all features of a class.
 * @date 2022/11/26 17:40
 */
public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException {
        // read class name from command line args or user input
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            var in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date): ");
            name = in.next();
        }

        // print class name and superclass name (if != Object)
        Class cl = Class.forName(name);
    }
}
