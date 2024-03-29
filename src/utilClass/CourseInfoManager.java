package utilClass;

import mainClass.Course;
import mainClass.Teacher;

import java.util.Scanner;

import static utilClass.MainMenu.waitForUser;
import static utilClass.SystemInfoManager.teachers;
import static utilClass.Utils.COURSES;

public class CourseInfoManager {
    // 查看课程教师列表
    public static void showCourseTeacherList() {
        System.out.println("请输入要查看的课程名称或编号：（输入 q 退出）");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();

        if (input.equalsIgnoreCase("q")) {
            return; // 退出循环
        }

        for(Course course : COURSES) {
            if (course.getName().equals(input) || course.getId().equals(input)) {
                System.out.println("课程教师列表：");
                for (int i = 0; i < course.getTeachers().size(); i++) {
                    System.out.println((i + 1) + ". " + course.getTeachers().get(i).getName());
                }
                return;
            }
        }

        System.out.println("未找到该课程，请检查输入是否正确。");
        waitForUser();
        showCourseTeacherList();
    }

    // 添加课程教师
    public static void addCourseTeacher() {
        System.out.println("请输入要添加教师的课程名称或编号：（输入 q 退出）");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();

        if (input.equalsIgnoreCase("q")) {
            return; // 退出循环
        }

        for (Course course : COURSES) {
            if (course.getName().equals(input) || course.getId().equals(input)) {
                System.out.println("请输入要添加的教师教师编号：");
                String teacherID = scanner.next();
                for (Teacher teacher : teachers) {
                    if (teacher.getId().equals(teacherID)) {
                        course.getTeachers().add(teacher);
                        System.out.println(teacher);
                        System.out.println("添加成功！");
                        waitForUser();
                        return;
                    }
                }
            }
        }

        System.out.println("未找到该教师，请检查输入是否正确。");
        waitForUser();
        addCourseTeacher();
    }

    // 删除课程教师
    public static void deleteCourseTeacher() {
        System.out.println("请输入要删除教师的课程名称或编号：（输入 q 退出）");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();

        if (input.equalsIgnoreCase("q")) {
            return; // 退出循环
        }

        for (Course course : COURSES) {
            if (course.getName().equals(input) || course.getId().equals(input)) {
                System.out.println("请输入要删除的教师教师编号：");
                String teacherID = scanner.next();
                for (Teacher teacher : teachers) {
                    if (teacher.getId().equals(teacherID)) {
                        course.getTeachers().remove(teacher);
                        System.out.println(teacher);
                        System.out.println("删除成功！");
                        waitForUser();
                        return;
                    }
                }
            }
        }

        System.out.println("未找到该教师，请检查输入是否正确。");
        waitForUser();
        deleteCourseTeacher(); // 递归调用以重新输入
    }

    // 查看课程分数占比
    public static void showCourseScoreWeight() {
        System.out.println("请输入要查看的课程名称或编号：（输入 q 退出）");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();

        if (input.equalsIgnoreCase("q")) {
            return; // 退出循环
        }

        for (Course course : COURSES) {
            if (course.getName().equals(input) || course.getId().equals(input)) {
                System.out.println("课程分数占比：");
                System.out.println("平时成绩：" + course.getRegularScoreWeight() * 100 + "%");
                System.out.println("期中成绩：" + course.getMidtermScoreWeight() * 100 + "%");
                System.out.println("实验成绩：" + course.getExperimentScoreWeight() * 100 + "%");
                System.out.println("期末成绩：" + course.getFinalScoreWeight() * 100 + "%");
                waitForUser();
                return;
            }
        }

        System.out.println("未找到该课程，请检查输入是否正确。");
        waitForUser();
        showCourseScoreWeight(); // 递归调用以重新输入
    }

    // 修改课程分数占比
    public static void setCourseScoreWeight() {
        System.out.println("请输入要修改分数占比的课程名称或编号：（输入 q 退出）");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();

        if (input.equalsIgnoreCase("q")) {
            return; // 退出循环
        }

        for (Course course : COURSES) {
            if (course.getName().equals(input) || course.getId().equals(input)) {
                System.out.println("请输入整数");
                System.out.println("请输入平时成绩占比：%");
                while (true) {
                    input = scanner.next();
                    if (InputValidator.isInteger(input)) {
                        course.setRegularScoreWeight(Double.parseDouble(input) / 100);
                        break;
                    } else {
                        System.out.println("输入的值不合法，请重新输入：");
                    }
                }
                System.out.println("请输入期中成绩占比：%");
                while (true) {
                    input = scanner.next();
                    if (InputValidator.isInteger(input)) {
                        course.setMidtermScoreWeight(Double.parseDouble(input) / 100);
                        break;
                    } else {
                        System.out.println("输入的值不合法，请重新输入：");
                    }
                }
                System.out.println("请输入实验成绩占比：%");
                while (true) {
                    input = scanner.next();
                    if (InputValidator.isInteger(input)) {
                        course.setExperimentScoreWeight(Double.parseDouble(input) / 100);
                        break;
                    } else {
                        System.out.println("输入的值不合法，请重新输入：");
                    }
                }
                System.out.println("请输入期末成绩占比：%");
                while (true) {
                    input = scanner.next();
                    if (InputValidator.isInteger(input)) {
                        course.setFinalScoreWeight(Double.parseDouble(input) / 100);
                        break;
                    } else {
                        System.out.println("输入的值不合法，请重新输入：");
                    }
                }
                return;
            }
        }

        System.out.println("未找到该课程，请检查输入是否正确。");
        waitForUser();
        setCourseScoreWeight(); // 递归调用以重新输入
    }


}
