package v1ch05.abstractClasses;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/11/26 11:34
 */
public class Student extends Person{
    private String major;

    public Student(String name, String major) {
        // pass name to superclass constructor
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return "a student majoring int " + major;
    }
}
