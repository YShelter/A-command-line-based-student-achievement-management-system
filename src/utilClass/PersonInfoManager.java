package utilClass;

import mainClass.Student;

import java.util.ArrayList;
import java.util.Scanner;

import static utilClass.InputValidator.inputGender;
import static utilClass.InputValidator.isInteger;
import static utilClass.MainMenu.waitForUser;
import static utilClass.SystemInfoManager.students;

public class PersonInfoManager {
    // 手动添加学生信息
    public static void addStudent() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> new_students = new ArrayList<>();

        int id = students.size();

        while (true) {
            System.out.println("请输入要添加的学生数量（输入 q 退出）：");
            String input = scanner.next();

            if (input.equalsIgnoreCase("q")) {
                return; // 退出循环
            }

            if (isInteger(input)) {
                int count = Integer.parseInt(input);
                System.out.println("输入的学生数量为：" + count);

                for (int i = 0; i < count; i++) {
                    System.out.println("请输入第" + (i + 1) + "个学生姓名：");
                    String name = scanner.next();
                    System.out.println("请输入第" + (i + 1) + "个学生性别：(男/女)");
                    String gender = inputGender();

                    // 将 i 格式化为四位定长的字符串作为学生的 ID
                    String studentId = String.format("%04d", ++id);

                    new_students.add(new Student(name, gender, studentId));
                    System.out.println("---------------------------");
                }
                students.addAll(new_students);
                System.out.println("学生信息添加成功，共" + students.size() + "人");
                waitForUser();
                break; // 结束循环
            } else {
                System.out.println("输入的不是一个整数，请重新输入。");
            }
        }
    }

    // 查找学生信息
    public static void findStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请选择查找方式：");
        System.out.println("1. 按学号查找");
        System.out.println("2. 按姓名查找");
        System.out.println("3. 返回上一级菜单");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                System.out.println("请输入要查找的学生学号：");
                String studentId = scanner.next();
                Student student = findStudentById(studentId);
                if (student != null) {
                    System.out.println("查找到的学生信息如下：");
                    System.out.println(student);
                }
                else {
                    System.out.println("学生不存在");
                }
                waitForUser();
                return;
            }
            case 2: {
                System.out.println("请输入要查找的学生姓名：");
                String studentName = scanner.next();
                ArrayList<Student> result = findStudentByName(studentName);
                if (!result.isEmpty()) {
                    System.out.println("查找到的学生信息如下：");
                    System.out.println(result);
                }else {
                    System.out.println("学生不存在");
                }
                waitForUser();
                return;
            }
            case 3:
                return;
            default:
                System.out.println("输入错误，请重新输入");
                findStudent();
        }
    }

    // 按学号查找学生
    public static Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    // 按姓名查找学生
    public static ArrayList<Student> findStudentByName(String studentName) {
        ArrayList<Student> result = new ArrayList<>();

        for (Student student : students) {
            if (student.getName().equals(studentName)) {
                result.add(student);
            }
        }

        if (!result.isEmpty()) {
            return result;
        }
        else {
            return new ArrayList<Student>();
        }
    }

    // 删除学生信息
    public static void deleteStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请选择删除方式：");
        System.out.println("1. 按学号删除");
        System.out.println("2. 按姓名删除");
        System.out.println("3. 返回上一级菜单");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                System.out.println("请输入要删除的学生学号：");
                String studentId = scanner.next();
                Student student = findStudentById(studentId);
                if (student != null) {
                    students.remove(student);
                    System.out.println("学生信息删除成功");
                }
                else {
                    System.out.println("学生不存在");
                }
                waitForUser();
                return;
            }
            case 2: {
                System.out.println("请输入要删除的学生姓名：");
                String studentName = scanner.next();
                ArrayList<Student> result = findStudentByName(studentName);
                if (!result.isEmpty()) {
                    students.removeAll(result);
                    System.out.println("学生信息删除成功");
                }else {
                    System.out.println("学生不存在");
                }
                waitForUser();
                return;
            }
            default:
                System.out.println("输入错误，请重新输入");
                deleteStudent();
        }
    }

    // 修改学生信息
}
