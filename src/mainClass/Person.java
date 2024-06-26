package mainClass;

/**
 *
 */
public class Person {
    private String name; // 姓名
    private String gender; // 性别

    public Person() {

    }

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "姓名：" + name + '\t' +
                ", 性别：" + gender + '\t';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
