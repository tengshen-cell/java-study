package v1ch05.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
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
        Class superclass = cl.getSuperclass();
        String modifiers = Modifier.toString(cl.getModifiers());
        if (modifiers.length() > 0) {
            System.out.print(modifiers + " ");
        }

        System.out.print("class " + name);
        if (superclass != null && superclass != Object.class) {
            System.out.println(" extends " + superclass.getName());
        }

        System.out.print("\n{\n");
        printConstructs(cl);
    }
    
    private static void printConstructs(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String name = constructor.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(constructor.getModifiers());
        }
    }
}
