package v1ch06.interfaces;

import java.util.Arrays;

/**
 * @author 滕广银
 * @description This program demonstrates the use of Comparable interface
 * @date 2022/11/27 17:31
 */
public class EmployeeSortTest {
    public static void main(String[] args) {
        var staff = new Employee[3];

        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Carl Cracker", 75000);
        staff[2] = new Employee("Tony Tester", 38000);

        Arrays.sort(staff);
        for (Employee employee : staff) {
            System.out.println("name=" + employee.getName() + ",salary=" + employee.getSalary());
        }
    }
}
