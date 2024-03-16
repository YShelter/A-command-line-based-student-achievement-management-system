package utilClass;

import java.util.Scanner;

import static utilClass.Utils.*;

public class ShowMainMenu {

    public static void showMainMenu() {

        while (true) {
            System.out.println(ANSI_BLUE + ANSI_BOLD + "欢迎使用学生成绩管理系统" + ANSI_RESET);

            System.out.println("请选择您要进行的操作：");

            System.out.println("1. 学生信息管理");
            System.out.println("2. 教师信息管理");
            System.out.println("3. 课程信息管理");
            System.out.println("4. 教学班信息管理");
            System.out.println("5. 选课信息管理");
            System.out.println("6. 成绩信息管理");
            System.out.println("7. 退出");

            Scanner scanner = new Scanner(System.in);

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("学生信息管理");
                    break;
                case 2:
                    System.out.println("教师信息管理");
                    break;
                case 3:
                    System.out.println("课程信息管理");
                    break;
                case 4:
                    System.out.println("教学班信息管理");
                    break;
                case 5:
                    System.out.println("选课信息管理");
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
}
