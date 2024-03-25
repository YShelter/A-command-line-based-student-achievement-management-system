package utilClass;

import mainClass.Student;
import mainClass.Teacher;

import java.util.ArrayList;
import java.util.Random;

import static utilClass.Utils.*;

public class CreatePerson {
    static Random random = new Random();

    public static void createStudents(ArrayList<Student> students) {
        createStudents(students, 150);
    }

    public static void createStudents(ArrayList<Student> students, int studentNum) {
        for (int i = 0; i < studentNum; i++) {
            String gender =  getGender();
            String name = getName(gender);

            // 将 i 格式化为四位定长的字符串作为学生的 ID
            String studentId = String.format("%04d", i+1);

            Student student = new Student(name, gender, studentId);

            students.add(student);
        }
        System.out.println("学生信息初始化完成,共" + students.size() + "人");
        System.out.println(students);
    }

    public static void createTeachers(ArrayList<Teacher> teachers) {
        createTeachers(teachers, 15);
    }

    public static void createTeachers(ArrayList<Teacher> teachers, int teacherNum) {
        for (int i = 0; i < teacherNum; i++) {
            String gender =  getGender();
            String name = getName(gender);

            // 将 i 格式化为三位定长的字符串作为老师的 ID
            String teacherId = String.format("%03d", i+1);

            Teacher teacher = new Teacher(name, gender, teacherId);

            teachers.add(teacher);
        }
        System.out.println("教师信息初始化完成，共" + teachers.size() + "人");
        System.out.println(teachers);
    }

    public static String getGender() {
        return random.nextInt(2) == 0 ? "男" : "女";
    }

    public static String getName(String gender) {
        String name = LAST_NAME_ARRAY[random.nextInt(LAST_NAME_ARRAY.length)];
        if (gender.equals("男")) {
            name += FIRST_NAME_MALE_ARRAY[random.nextInt(FIRST_NAME_MALE_ARRAY_LENGTH)];
        } else {
            name += FIRST_NAME_FEMALE_ARRAY[random.nextInt(FIRST_NAME_FEMALE_ARRAY_LENGTH)];
        }
        return name;
    }


}
