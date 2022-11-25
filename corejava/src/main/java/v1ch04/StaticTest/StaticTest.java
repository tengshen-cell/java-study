package v1ch04.StaticTest;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/11/25 11:11
 */
public class StaticTest {
    public static void main(String[] args) {
        var staff = new Employee[3];

        staff[0] = new Employee("Tom", 40000);
        staff[1] = new Employee("Dick", 60000);
        staff[2] = new Employee("Harry", 65000);

        for (Employee employee : staff) {
            System.out.println("name=" + employee.getName() + ",id=" + employee.getId() +
                    employee.getSalary());
        }

        // calls static method
        int n = Employee.advanceId();
        System.out.println("Next issued is=" +n);

    }
}

class Employee {
    private static int nextId = 1;

    private String name;
    private double salary;
    private int id;

    public Employee(String n, double s) {
        name = n;
        salary = s;
        id = advanceId();
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

    public static int advanceId() {
        // obtain next available id
        int r = nextId;
        nextId++;
        return r;
    }

    public static void main(String[] args) {
        var e = new Employee("Harry", 50000);
        System.out.println(e.getName() + " " + e.getSalary());
    }
}
