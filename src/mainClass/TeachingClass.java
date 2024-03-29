package mainClass;

import java.util.List;

public class TeachingClass { // 教学班
    private int id; // 教学班编号
    private Course course; // 课程
    private Teacher teacher; // 教师
    private List<Student> students; // 学生列表
    private String semester; // 开课学年学期
    private ClassScore classScore; // 教学班成绩管理

    public TeachingClass() {
    }

    public TeachingClass(int id, Course course, Teacher teacher, List<Student> students, String semester, ClassScore classScore) {
        this.id = id;
        this.course = course;
        this.teacher = teacher;
        this.students = students;
        this.semester = semester;
        this.classScore = classScore;
    }

    @Override
    public String toString() {
        return "TeachingClass{" +
                "教学班编号：" + id + "\t" +
                ", 课程名称：" + course.getName() + "\t" +
                ", 开课学期：" + semester + '\n' +
                ", 任课教师：" + teacher +
                ", 学生列表：" + students + "\n" +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public ClassScore getClassScore() {
        return classScore;
    }

    public void setClassScore(ClassScore classScore) {
        this.classScore = classScore;
    }
}
