package utilClass;

import mainClass.Student;
import mainClass.Teacher;
import mainClass.TeachingClass;

import java.util.ArrayList;

public class SystemInfoManager {
    protected ArrayList<Student> students;
    protected ArrayList<Teacher> teachers;
    protected ArrayList<TeachingClass> teachingClasses;

    public static void showStudentInfoManager() {
        System.out.println("学生信息管理");
    }
}
