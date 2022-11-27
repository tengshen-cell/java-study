package v1ch05.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
        System.out.println();
        printMethods(cl);
        System.out.println();
        printFields(cl);
    }

    // Prints all constructors of a class
    private static void printConstructs(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String name = constructor.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(constructor.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");
            Class[] parameterTypes = constructor.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                if (j > 0) System.out.print(",");
                System.out.print(parameterTypes[j].getName());
            }
            System.out.println("):");
        }
    }

    public static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            Class reType = method.getReturnType();
            String name = method.getName();

            System.out.print("  ");
            // print modifiers, return type and method name
            String modifiers = Modifier.toString(method.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(reType.getName() + " " + name + "(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(parameterTypes[j].getName());
            }
            System.out.println("):");
        }
    }

    // Prints all fields of a class
    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            Class<?> type = field.getType();
            String name = field.getName();
            String modifiers = Modifier.toString(field.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}
