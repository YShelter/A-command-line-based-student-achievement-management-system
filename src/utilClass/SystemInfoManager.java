package utilClass;

import mainClass.*;

import java.util.ArrayList;
import java.util.Map;

public class SystemInfoManager {
    protected static ArrayList<Student> students = new ArrayList<>(); // 记录所有学生信息
    protected static ArrayList<Teacher> teachers = new ArrayList<>(); // 记录所有教师信息
    protected static ArrayList<TeachingClass> teachingClasses = new ArrayList<>(); // 记录所有教学班信息
    protected static Map<Student, Map<Course, CourseScore>> StudentScores; //学生成绩

}
