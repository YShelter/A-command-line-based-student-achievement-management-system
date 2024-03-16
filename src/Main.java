import mainClass.Student;
import mainClass.Teacher;
import utilClass.CreatePerson;

import java.util.ArrayList;
import java.util.List;

import static utilClass.ShowMainMenu.showMainMenu;
import static utilClass.Utils.*;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>(); // 记录所有学生信息
        ArrayList<Teacher> teachers = new ArrayList<>(); // 记录所有教师信息

        CreatePerson.createStudents(students);

        showMainMenu();
    }
}