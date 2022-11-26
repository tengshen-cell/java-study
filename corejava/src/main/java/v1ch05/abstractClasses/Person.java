package v1ch05.abstractClasses;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/11/26 11:11
 */
public abstract class Person {
    public abstract String getDescription();
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
