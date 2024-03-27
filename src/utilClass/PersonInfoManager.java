package utilClass;

import mainClass.Student;
import mainClass.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

import static utilClass.InputValidator.inputGender;
import static utilClass.InputValidator.isInteger;
import static utilClass.MainMenu.waitForUser;
import static utilClass.SystemInfoManager.students;
import static utilClass.SystemInfoManager.teachers;

public class PersonInfoManager {
    public static Scanner scanner = new Scanner(System.in);

    // 手动添加学生或教师信息
    public static <T> void addPerson(Utils.PERSON_TYPE type) {
//        Scanner scanner = new Scanner(System.in);

        ArrayList<T> newPeople = new ArrayList<>(); // 使用泛型类型来存储新的人员信息

        int id = (type == Utils.PERSON_TYPE.STUDENT) ? students.size() : teachers.size(); // 根据类型选择起始 ID

        while (true) {
            System.out.println("请输入要添加的" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + "数量（输入 q 退出）：");
            String input = scanner.next();

            if (input.equalsIgnoreCase("q")) {
                return; // 退出循环
            }

            if (isInteger(input)) {
                int count = Integer.parseInt(input);
                System.out.println("要添加的" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + "数量为：" + count);

                for (int i = 0; i < count; i++) {
                    System.out.println("请输入第" + (i + 1) + "个" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + "姓名：");
                    String name = scanner.next();
                    System.out.println("请输入第" + (i + 1) + "个" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + "性别：(男/女)");
                    String gender = inputGender();

                    // 将 i 格式化为四位定长的字符串作为学生的 ID
                    String personId = String.format("%04d", ++id);

                    if ((type == Utils.PERSON_TYPE.STUDENT)) {
                        newPeople.add((T) new Student(name, gender, personId)); // 向学生列表中添加新学生
                    } else {
                        newPeople.add((T) new Teacher(name, gender, personId)); // 向老师列表中添加新老师
                    }

                    System.out.println("---------------------------");
                }

                if ((type == Utils.PERSON_TYPE.STUDENT)) {
                    students.addAll((ArrayList<Student>) newPeople); // 将新学生列表添加到学生列表中
                    System.out.println("学生信息添加成功，共" + newPeople.size() + "人");
                } else {
                    teachers.addAll((ArrayList<Teacher>) newPeople); // 将新老师列表添加到老师列表中
                    System.out.println("老师信息添加成功，共" + newPeople.size() + "人");
                }

                waitForUser();
                break; // 结束循环
            } else {
                System.out.println("输入的不是一个整数，请重新输入。");
            }
        }
    }

    // 查找学生或老师信息
    public static <T> void findPerson(Utils.PERSON_TYPE type) {
//        Scanner scanner = new Scanner(System.in);

        System.out.println("请选择查找方式：");
        System.out.println("1. 按" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学号" : "教师编号") + "查找");
        System.out.println("2. 按姓名查找");
        System.out.println("3. 返回上一级菜单");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                System.out.println("请输入要查找的" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学号" : "教师编号") + "：");
                String PersonId = scanner.next();
                T person = findPersonById(type, PersonId);
                if (person != null) {
                    System.out.println("查找到的" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + "信息如下：");
                    System.out.println(person);
                } else {
                    System.out.println("查找的" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + "不存在");
                }
                waitForUser();
                return;
            }
            case 2: {
                System.out.println("请输入要查找的" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + "姓名：");
                String personName = scanner.next();
                ArrayList<T> result = findPersonByName(type, personName);
                if (!result.isEmpty()) {
                    System.out.println("查找到的" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + "信息如下：");
                    System.out.println(result);
                } else {
                    System.out.println("查找的" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + "不存在");
                }
                waitForUser();
                return;
            }
            case 3:
                return;
            default:
                System.out.println("输入错误，请重新输入");
                findPerson(type);
        }
    }

    // 按学号查找学生或老师
    public static <T> T findPersonById(Utils.PERSON_TYPE type, String personId) {
        if (type == Utils.PERSON_TYPE.STUDENT) {
            for (Student student : students) {
                if (student.getId().equals(personId)) {
                    return (T) student;
                }
            }
        } else {
            for (Teacher teacher : teachers) {
                if (teacher.getId().equals(personId)) {
                    return (T) teacher;
                }
            }
        }

        return null;
    }

    // 按姓名查找学生或老师
    public static <T> ArrayList<T> findPersonByName(Utils.PERSON_TYPE type, String personName) {
        ArrayList<T> result = new ArrayList<>();

        if (type == Utils.PERSON_TYPE.STUDENT) {
            for (Student student : students) {
                if (student.getName().equals(personName)) {
                    result.add((T) student);
                }
            }
        } else {
            for (Teacher teacher : teachers) {
                if (teacher.getName().equals(personName)) {
                    result.add((T) teacher);
                }
            }
        }

        if (!result.isEmpty()) {
            return result;
        } else {
            return new ArrayList<T>();
        }
    }

    // 删除学生或教师信息
    public static <T> void deletePerson(Utils.PERSON_TYPE type) {
//        Scanner scanner = new Scanner(System.in);

        System.out.println("请选择删除方式：");
        System.out.println("1. 按" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学号" : "教师编号") + "删除");
        System.out.println("2. 按姓名删除");
        System.out.println("3. 返回上一级菜单");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                System.out.println("请输入要删除的" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + ((type == Utils.PERSON_TYPE.STUDENT) ? "学号" : "编号") + "：");
                String personId = scanner.next();
                T person = findPersonById(type, personId);
                if (person != null) {
                    if (type == Utils.PERSON_TYPE.STUDENT) {
                        students.remove(person);
                    } else {
                        teachers.remove(person);
                    }
                    System.out.println(((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + "信息删除成功");
                } else {
                    System.out.println(((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + "不存在");
                }
                waitForUser();
                return;
            }
            case 2: {
                System.out.println("请输入要删除的" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + "姓名：");
                String personName = scanner.next();
                ArrayList<T> result = findPersonByName(type, personName);
                if (!result.isEmpty()) {
                    if (type == Utils.PERSON_TYPE.STUDENT) {
                        students.removeAll(result);
                    } else {
                        teachers.removeAll(result);
                    }
                    System.out.println(((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + "信息删除成功");
                } else {
                    System.out.println(((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + "不存在");
                }
                waitForUser();
                return;
            }
            case 3:
                return;
            default:
                System.out.println("输入错误，请重新输入");
                deletePerson(type);
        }
    }

    // 修改学生或老师信息
    public static <T> void alterPersonInfo(Utils.PERSON_TYPE type) {
//        Scanner scanner = new Scanner(System.in);

        System.out.println("请选择查找方式：");
        System.out.println("1. 按" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学号" : "教师编号") + "查找");
        System.out.println("2. 按姓名查找");
        System.out.println("3. 返回上一级菜单");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                System.out.println("请输入要修改的" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学生学号" : "教师编号") + "：");
                String PersonId = scanner.next();
                T person = findPersonById(type, PersonId);
                if (person != null) {
                    System.out.println("要修改的" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + "信息如下：");
                    System.out.println(person);
                    inputAlterInfo(person, type);
                } else {
                    System.out.println("要修改的" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + "不存在");
                }
                waitForUser();
                return;
            }
            case 2: {
                System.out.println("请输入要修改的" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + "姓名：");
                String personName = scanner.next();
                ArrayList<T> result = findPersonByName(type, personName);
                if (result.size() > 1) {
                    System.out.println("存在同名" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + "，信息如下：");
                    System.out.println(result);
                    System.out.println("请使用"+ ((type == Utils.PERSON_TYPE.STUDENT) ? "学生学号" : "教师编号") + "重新修改。");
                } else if (result.size() == 1) {
                    System.out.println("要修改的" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + "信息如下：");
                    System.out.println(result.get(0));
                    inputAlterInfo(result.get(0), type);
                } else {
                    System.out.println("要修改的" + ((type == Utils.PERSON_TYPE.STUDENT) ? "学生" : "老师") + "不存在");
                }
                waitForUser();
                return;
            }
            case 3:
                return;
            default:
                System.out.println("输入错误，请重新输入");
                alterPersonInfo(type);

        }
    }

    // 输入修改信息
    public static <T> void inputAlterInfo(T person, Utils.PERSON_TYPE type) {
        System.out.println("请输入新的姓名：");
        String name = scanner.next();
        System.out.println("请输入新的性别：");
        String gender = inputGender();

        if (type == Utils.PERSON_TYPE.STUDENT) {
            ((Student) person).setName(name);
            ((Student) person).setGender(gender);
        }
        else {
            ((Teacher) person).setName(name);
            ((Teacher) person).setGender(gender);
        }
        System.out.println("修改成功,修改后的信息如下：");
        System.out.println(person);
    }


}
