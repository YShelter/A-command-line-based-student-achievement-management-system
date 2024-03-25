package mainClass;

public class Student extends Person {
    String id; // 学号

    public Student() {
    }

    public Student(String name, String gender, String id) {
        super(name, gender);
        this.id = id;
    }

    @Override
    public String toString() {
        return  "Student{ " +
                super.toString() +
                ", 学号： " + id +
                " }\n";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
