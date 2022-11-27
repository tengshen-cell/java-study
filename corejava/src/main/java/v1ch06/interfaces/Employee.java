package v1ch06.interfaces;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/11/27 17:17
 */
public class Employee implements Comparable<Employee> {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }


    @Override
    public int compareTo(Employee other) {
        return Double.compare(salary, other.salary);
    }
}
