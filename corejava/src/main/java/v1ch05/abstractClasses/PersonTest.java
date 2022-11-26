package v1ch05.abstractClasses;

/**
 * @author 滕广银
 * @description This program demonstrates abstract classes.
 * @date 2022/11/26 11:42
 */
public class PersonTest {
    public static void main(String[] args) {
        var people = new Person[2];

        // fill the people array with Student and Employee objects
        people[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        people[1] = new Student("Maria Morris", "computer science");

        // print out names and descriptions of all Person objects
        for (Person person : people) {
            System.out.println(person.getName() +", " + person.getDescription());
        }
    }
}
