package utilClass;

import mainClass.*;

import java.util.ArrayList;
import java.util.HashMap;

public class SystemInfoManager {
    protected static ArrayList<Student> students = new ArrayList<>(); // 记录所有学生信息
    protected static ArrayList<Teacher> teachers = new ArrayList<>(); // 记录所有教师信息
    protected static ArrayList<Course> courses = new ArrayList<>(); // 记录所有开课课程信息
    protected static ArrayList<TeachingClass> teachingClasses = new ArrayList<>(); // 记录所有教学班信息
    protected static HashMap<Student, HashMap<Course, CourseScore>> studentScores = new HashMap<>(); //学生成绩

}
