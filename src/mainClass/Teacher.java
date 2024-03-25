package mainClass;

public class Teacher extends Person {
    String id; // 教师编号

    public Teacher() {
    }

    public Teacher(String id) {
        this.id = id;
    }

    public Teacher(String name, String gender, String id) {
        super(name, gender);
        this.id = id;
    }

    @Override
    public String toString() {
        return  "Teacher{ " +
                super.toString() +
                "教师编号： " + id +
                " }\n";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
