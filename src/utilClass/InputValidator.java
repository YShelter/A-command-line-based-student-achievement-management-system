package utilClass;

import java.util.Scanner;

// 检查用户输入是否合法
public class InputValidator {

    // 检查字符串是否为整数
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 检查字符串是否为指定的值
    public static String inputGender() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String gender = scanner.next();
            if (gender.equalsIgnoreCase("男") || gender.equalsIgnoreCase("女")) {
                return gender;
            }
            else {
                System.out.println("输入的性别不合法，请重新输入：（男/女）");
            }

        }


    }
}
