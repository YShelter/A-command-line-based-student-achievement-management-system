package mainClass;

public class Student extends Person {
    int id; // 学号

    public Student() {
    }

    public Student(String name, String gender, int id) {
        super(name, gender);
        this.id = id;
    }

    @Override
    public String toString() {
        return  "Student{" +
                super.toString() +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
