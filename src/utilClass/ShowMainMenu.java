package utilClass;

import java.util.Scanner;

import static utilClass.Utils.*;

public class ShowMainMenu {

    // 显示主菜单
    public static void showMainMenu() {

        while (true) {
            System.out.println(ANSI_BLUE + ANSI_BOLD + "欢迎使用学生成绩管理系统" + ANSI_RESET);

            System.out.println("请选择您要进行的操作：");

            System.out.println("1. 初始化数据");
            System.out.println("2. 学生信息管理");
            System.out.println("3. 教师信息管理");
            System.out.println("4. 课程信息管理");
            System.out.println("5. 教学班信息管理");
            System.out.println("6. 成绩信息管理");
            System.out.println("7. 退出");

            Scanner scanner = new Scanner(System.in);

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
//                    System.out.println("初始化数据");
                    showStudentMenu();
                    break;
                case 2:
                    System.out.println("学生信息管理");
                    break;
                case 3:
                    System.out.println("教师信息管理");
                    break;
                case 4:
                    System.out.println("课程信息管理");
                    break;
                case 5:
                    System.out.println("教学班信息管理");
                    break;
                case 6:
                    System.out.println("成绩信息管理");
                    break;
                case 7:
                    System.out.println("退出");
                    return;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }
    }

    //
    public static void showStudentMenu() {
        System.out.println(ANSI_BLUE + ANSI_BOLD + "欢迎使用学生成绩管理系统" + ANSI_RESET);

        System.out.println("请选择您要初始话的数据：");

        System.out.println("1. 初始化学生数据");
        System.out.println("2. 初始化教师数据");
        System.out.println("3. 生成课程数据");
        System.out.println("4. 初始化教学班数据");
        System.out.println("5. 返回上级目录");
        System.out.println("6. 成绩信息管理");
        System.out.println("7. 退出");

        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("初始化学生数据");
                break;
            case 2:
                System.out.println("初始化教师数据");
                break;
            case 3:
                System.out.println("生成课程数据");
                break;
            case 4:
                System.out.println("初始化教学班数据");
                break;
            case 5:
                System.out.println("返回上级目录");
                showMainMenu();
                break;
            case 6:
                System.out.println("成绩信息管理");
                break;
            case 7:
                System.out.println("退出");
                return;
            default:
                System.out.println("输入错误，请重新输入");
                break;
        }

    }
}
