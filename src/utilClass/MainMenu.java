package utilClass;

import mainClass.Course;

import java.util.Scanner;

import static utilClass.CourseInfoManager.*;
import static utilClass.CreatePerson.createStudents;
import static utilClass.CreatePerson.createTeachers;
import static utilClass.PersonInfoManager.*;
import static utilClass.TeachingClassManager.addTeacherForCourse;
import static utilClass.TeachingClassManager.createRandomClass;
import static utilClass.Utils.*;

public class MainMenu extends SystemInfoManager {
//    private static ArrayList<Student> students = new ArrayList<>(); // 记录所有学生信息
//    private static ArrayList<Teacher> teachers = new ArrayList<>(); // 记录所有教师信息
//    private static ArrayList<TeachingClass> teachingClasses = new ArrayList<>(); // 记录所有教学班信息

    // 显示主菜单
    public static void showMainMenu() {

        while (true) {
            showTitle();

            System.out.println("1. 初始化数据");
            System.out.println("2. 学生信息管理");
            System.out.println("3. 教师信息管理");
            System.out.println("4. 课程信息管理");
            System.out.println("5. 教学班信息管理");
            System.out.println("6. 成绩信息管理");
            System.out.println("7. 退出系统");

            System.out.println("-------------------------------");
            System.out.println("请选择您要进行的操作：");

            Scanner scanner = new Scanner(System.in);

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
//                    System.out.println("初始化数据");
                    showInitialDateMenu();
                    break;
                case 2:
//                    System.out.println("学生信息管理");
                    showStudentInfoManagerMenu();
                    break;
                case 3:
//                    System.out.println("教师信息管理");
                    showTeacherInfoManagerMenu();
                    break;
                case 4:
//                    System.out.println("课程信息管理");
                    showCourseInfoManagerMenu();
                    break;
                case 5:
                    System.out.println("教学班信息管理");
                    break;
                case 6:
                    System.out.println("成绩信息管理");
                    break;
                case 7:
                    exitSystem();
                    return;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }

            clearConsole();
        }
    }

    // 显示初始化数据菜单
    public static void showInitialDateMenu() {
        while (true) {
            showTitle();

            System.out.println("1. 初始化学生数据");
            System.out.println("2. 初始化教师数据");
            System.out.println("3. 生成课程数据");
            System.out.println("4. 初始化教学班数据");
            System.out.println("5. 返回上级目录");
            System.out.println("6. 退出系统");
            System.out.println("-------------------------------");
            System.out.println("请选择您要初始化的数据：");

            Scanner scanner = new Scanner(System.in);

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                case 2:
                    initializeData(choice);
                    break;
                case 3:
//                    System.out.println("生成课程数据");
                    addTeacherForCourse(teachers);
                    break;
                case 4:
//                    System.out.println("初始化教学班数据");
                    createRandomClass(students, teachingClasses);
                    break;
                case 5:
//                    System.out.println("返回上级目录");
                    return;
                case 6:
                    exitSystem();
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }

            waitForUser();
            clearConsole();
        }

    }

    // 初始化数据
    public static void initializeData(int choice) {
        switch (choice) {
            case 1: {
                if (!students.isEmpty()) {
                    System.out.println("学生信息已经初始化，是否重新初始化？（Y/N）");
                    Scanner scanner = new Scanner(System.in);
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("N")) {
                        return;
                    }
                }
                students.clear();
                System.out.println("请输入学生数量：（按回车后默认初始化 150 人）");
                int studentNum = inputNum();
                if (studentNum > 0) {
                    createStudents(students, studentNum);
                } else {
                    createStudents(students);
                }
                return;
            }
            case 2: {
                if (!teachers.isEmpty()) {
                    System.out.println("教师信息已经初始化，是否重新初始化？（Y/N）");
                    Scanner scanner = new Scanner(System.in);
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("N")) {
                        return;
                    }
                }
                teachers.clear();
                System.out.println("请输入教师数量：（按回车后默认初始化 15 人）");
                int teacherNum = inputNum();
                if (teacherNum > 0) {
                    createTeachers(teachers, teacherNum);
                } else {
                    createTeachers(teachers);
                }
            }
        }
    }

    // 自定义初始化人数
    public static int inputNum() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int count;
        if (input.trim().isEmpty()) {
            count = 0; // 使用默认值
        } else {
            count = Integer.parseInt(input);
        }
        return count;

    }

    // 显示学生信息管理菜单
    public static void showStudentInfoManagerMenu() {
        while (true) {
            showTitle();

            System.out.println("1. 查看所有学生信息");
            System.out.println("2. 新增学生信息");
            System.out.println("3. 查找学生信息");
            System.out.println("4. 删除学生信息");
            System.out.println("5. 修改学生信息");
            System.out.println("6. 返回上级目录");
            System.out.println("7. 退出系统");

            System.out.println("-------------------------------");
            System.out.println("请选择您要进行的操作：");

            Scanner scanner = new Scanner(System.in);

            int choice = scanner.nextInt();

            PERSON_TYPE type = PERSON_TYPE.STUDENT;

            switch (choice) {
                case 1:
//                    System.out.println("查看所有学生信息");
                    if (students.isEmpty()) {
                        System.out.println("学生信息为空，请先初始化数据");
                        waitForUser();
                        break;
                    }
                    System.out.println("学生信息如下：");
                    System.out.println(students);
                    waitForUser();
                    break;
                case 2:
//                    System.out.println("新增学生信息");
                    addPerson(type);
                    break;
                case 3:
//                    System.out.println("查找学生信息");
                    findPerson(type);
                    break;
                case 4:
//                    System.out.println("删除学生信息");
                    deletePerson(type);
                    break;
                case 5:
//                    System.out.println("修改学生信息");
                    alterPersonInfo(type);
                    break;
                case 6:
//                    System.out.println("返回上级目录");
                    return;
                case 7:
                    exitSystem();
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
            clearConsole();
        }
    }

    // 显示学生信息管理菜单
    public static void showTeacherInfoManagerMenu() {
        while (true) {
            showTitle();

            System.out.println("1. 查看所有老师信息");
            System.out.println("2. 新增老师信息");
            System.out.println("3. 查找老师信息");
            System.out.println("4. 删除老师信息");
            System.out.println("5. 修改老师信息");
            System.out.println("6. 返回上级目录");
            System.out.println("7. 退出系统");

            System.out.println("-------------------------------");
            System.out.println("请选择您要进行的操作：");

            Scanner scanner = new Scanner(System.in);

            int choice = scanner.nextInt();

            PERSON_TYPE type = PERSON_TYPE.TEACHER;

            switch (choice) {
                case 1: {
//                    System.out.println("查看所有老师信息");
                    if (teachers.isEmpty()) {
                        System.out.println("教师信息为空，请先初始化数据");
                        waitForUser();
                        break;
                    }
                    System.out.println("教师信息如下：");
                    System.out.println(teachers);
                    waitForUser();
                    break;
                }
                case 2:
//                    System.out.println("新增老师信息");
                    addPerson(type);
                    break;
                case 3:
//                    System.out.println("查找老师信息");
                    findPerson(type);
                    break;
                case 4:
//                    System.out.println("删除老师信息");
                    deletePerson(type);
                    break;
                case 5:
//                    System.out.println("修改老师信息");
                    alterPersonInfo(type);
                    break;
                case 6:
//                    System.out.println("返回上级目录");
                    return;
                case 7:
                    exitSystem();
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
            clearConsole();
        }
    }

    // 显示课程信息管理
    public static void showCourseInfoManagerMenu() {
        showTitle();

        System.out.println("1. 查看所有课程信息");
        System.out.println("2. 查看课程教师列表");
        System.out.println("3. 添加课程教师");
        System.out.println("4. 删除课程教师");
        System.out.println("5. 查看课程分数占比");
        System.out.println("6. 修改课程分数占比");
        System.out.println("7. 返回上级目录");
        System.out.println("8. 退出系统");

        System.out.println("-------------------------------");
        System.out.println("请选择您要进行的操作：");

        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                System.out.println("课程信息如下：");
                for (Course course : COURSES) {
                    System.out.println(course);
                }
                waitForUser();
                break;
            }
            case 2:
                showCourseTeacherList();
                break;
            case 3:
                addCourseTeacher();
                break;
            case 4:
                deleteCourseTeacher();
                break;
            case 5:
                showCourseScoreWeight();
                break;
            case 6:
                setCourseScoreWeight();
                break;
            case 7:
                return;
            case 8:
                exitSystem();
                break;
            default:
                System.out.println("输入错误，请重新输入");
                break;
        }
    }

    // 显示系统名称
    public static void showTitle() {
        System.out.println(ANSI_BLUE + ANSI_BOLD + "欢迎使用学生成绩管理系统" + ANSI_RESET);
    }

    // 等待用户操作
    public static void waitForUser() {
        System.out.println("按回车后继续...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    // 清空控制台
    public static void clearConsole() {
        // 打印大量的空白行
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    // 退出系统
    public static void exitSystem() {
        System.out.println(ANSI_YELLOW + ANSI_BOLD + "欢迎再次使用学生成绩管理系统" + ANSI_RESET);
        System.exit(0);
    }
}
