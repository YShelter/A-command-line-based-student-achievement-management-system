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
                "学号： " + id + "\t, " +
                super.toString() +
                " }\n";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
