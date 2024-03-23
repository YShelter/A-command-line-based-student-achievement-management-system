package utilClass;

import mainClass.Student;
import mainClass.Teacher;

import java.util.ArrayList;
import java.util.Random;

import static utilClass.Utils.*;

public class CreatePerson {
    static Random random = new Random();
    public static void createStudents(ArrayList<Student> students) {
        for (int i = 0; i < 150; i++) {
            String gender =  getGender();
            String name = getName(gender);

            Student student = new Student(name, gender, i);

            students.add(student);
        }
    }

    public static void createTeachers(ArrayList<Teacher> teachers) {
        for (int i = 0; i < 20; i++) {
            String gender =  getGender();
            String name = getName(gender);

            Teacher teacher = new Teacher(name, gender, i);

            teachers.add(teacher);
        }
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
