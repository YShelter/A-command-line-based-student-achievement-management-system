package mainClass;

public class Teacher extends Person {
    int id; // 教师编号

    public Teacher() {
    }

    public Teacher(int id) {
        this.id = id;
    }

    public Teacher(String name, String gender, int id) {
        super(name, gender);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
