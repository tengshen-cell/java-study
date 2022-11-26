package v1ch04.ConstructorTest;

import java.util.Random;

/**
 * @author 滕广银
 * @description This program demonstrates object construction
 * @date 2022/11/26 20:33
 */
public class ConstructorTest {
    public static void main(String[] args) {
        var staff = new Employee[3];
        staff[0] = new Employee("Harry", 4000);
        staff[1] = new Employee(6000);
        staff[2] = new Employee();

        for (Employee employee : staff) {
            System.out.println("name=" + employee.getName() + ",id=" + employee.getId() + ",salary="
                    + employee.getSalary());
        }
    }
}

class Employee {
    private static int nextId;

    private int id;
    // instance field initialization
    private String name = "";
    private double salary;

    static {
        var generator = new Random();
        // set nextId to a random number between 0 and 9999
        nextId = generator.nextInt(1000);
    }

    // object initialization block
    {
        id = nextId;
        nextId++;
    }

    // three overloaded constructors
    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public Employee(double s) {
        // calls the Employee(String, double) constructor
        this("Employee #" + nextId, s);
    }

    public Employee() {
        // name initialized to "" -- see above
        // salary not explicitly set--initialized to 0
        // id initialized in initialization block
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
}
