package utilClass;

import mainClass.*;

import java.time.LocalDate;
import java.util.*;

import static utilClass.MainMenu.waitForUser;
import static utilClass.SystemInfoManager.*;
import static utilClass.Utils.COURSES;
import static utilClass.Utils.SEMESTERS;

public class TeachingClassManager {
    static Random random = new Random();

    // 在课程中随机添加教学老师
    public static void addTeacherForCourse(ArrayList<Teacher> teachers) {
        HashSet<Integer> randomSet = new HashSet<>();

        for (Course course : COURSES) {
            int teacherCount = random.nextInt(3) + 2; // 随机选择一个教师人数

            for (int j = 0; j < teacherCount; j++) {
                int teacher = random.nextInt(teachers.size()); // 随机选择一个教师

                while (randomSet.contains(teacher)) { // 对教师名单进行去重
                    teacher = random.nextInt(teachers.size());
                }
                randomSet.add(teacher);

                course.getTeachers().add(teachers.get(teacher)); // 添加教师
            }

            randomSet.clear(); // 清空教师名单
        }

//        System.out.println("课程详情：" + Arrays.toString(COURSES));

    }

    // 创建教学班
    public static void createRandomClass(ArrayList<Student> students, ArrayList<TeachingClass> teachingClasses) {
        int courseNum = random.nextInt(4) + 3;
        ClassScore classScore = new ClassScore(new HashMap<>());
        HashSet<Integer> studentSet = new HashSet<>(); // 记录已经选择过的学生
        HashSet<Integer> courseSet = new HashSet<>(); // 记录已经选择过的课程
        int courseID = 0;


        for (int i = 0; i < courseNum; i++) {

            int courseIndex = random.nextInt(COURSES.length);
            while (courseSet.contains(courseIndex)) { // 对课程名单进行去重
                courseIndex = random.nextInt(COURSES.length);
            }
            courseSet.add(courseIndex);

            courses.add(COURSES[courseIndex]);// 向开课列表中添加课程

            for (int j = 0; j < COURSES[courseIndex].getTeachers().size(); j++) { // 遍历课程中的教师
                int studentNum = random.nextInt(6) + 20; // 随机选择一个班级人数
                ArrayList<Student> studentList = new ArrayList<>();

                for (int k = 0; k < studentNum; k++) {
                    int student; // 随机选择一个学生

                    while (true) { // 对学生名单进行去重
                        student = random.nextInt(students.size());

                        if (studentSet.contains(student)) {
                            continue;
                        }

                        if (studentScores.containsKey(students.get(student))) { // 判断学生是否已经存在
                            if (studentScores.get(students.get(student)).containsKey(COURSES[courseIndex])) { // 判断学生是否选择了同一门课程的不同班级
                                continue;
                            }
                        }

                        studentSet.add(student);
                        break;
                    }

                    Student currentStudent = students.get(student);

                    studentList.add(currentStudent); // 添加学生
                    classScore.getScores().put(currentStudent, new CourseScore()); // 添加学生成绩


                    if (studentScores.containsKey(currentStudent)) { // 判断学生是否已经存在
                        studentScores.get(currentStudent).put(COURSES[courseIndex], new CourseScore()); // 添加学生成绩
                    } else {
                        HashMap<Course, CourseScore> newScore = new HashMap<>();
                        newScore.put(COURSES[courseIndex], new CourseScore());
                        studentScores.put(currentStudent, newScore);
                    }
                }
                String semester = SEMESTERS[random.nextInt(SEMESTERS.length)]; // 随机选择一个学年学期
                TeachingClass tc = new TeachingClass(courseID, COURSES[courseIndex], COURSES[courseIndex].getTeachers().get(j), studentList, semester, classScore);
                teachingClasses.add(tc); // 添加教学班
                courseID++;
            }

            studentSet.clear(); // 清空学生名单

        }

        ensureStudentCourse(students); // 确保每个学生至少选择了三门课程

//        for (TeachingClass teachingClass : teachingClasses) {
//            System.out.println(teachingClass);
//            System.out.println("====================================");
//        }
    }

    // 确保每个学生至少选择了三门课程
    public static void ensureStudentCourse(ArrayList<Student> students) {
        for (Student student : students) {
            int courseCount = random.nextInt((courses.size() - 3)) + 3;

            // 确保学生在 studentScores 中有对应的记录
            if (!studentScores.containsKey(student)) {
                studentScores.put(student, new HashMap<>());
            }

            while (studentScores.get(student).size() < courseCount) {

                ArrayList<Course> availableCourses = new ArrayList<>();

                for (Course course : courses) { // 遍历课程
                    if (!studentScores.get(student).containsKey(course)) { // 如果学生选择了该课程则跳过
                        availableCourses.add(course);
                    }
                }

                int courseIndex = random.nextInt(availableCourses.size()); // 随机选择一门未选择的课程
                Course currentCourse = availableCourses.get(courseIndex);

                ArrayList<TeachingClass> availableClasses = new ArrayList<>();

                for (TeachingClass teachingClass : teachingClasses) {
                    if (teachingClass.getCourse().equals(currentCourse)) {
                        availableClasses.add(teachingClass);
                    }
                }

                int classIndex = random.nextInt(availableClasses.size()); // 随机选择未选择的课程的教学班
                TeachingClass currentClass = availableClasses.get(classIndex);

                currentClass.getStudents().add(student); // 添加学生
                currentClass.getClassScore().getScores().put(student, new CourseScore()); // 添加学生成绩
                studentScores.get(student).put(currentCourse, new CourseScore());

            }
        }
    }

    // 查看教学班
    public static void showTeachingClass() {
        if (checkTeachingClass()) { // 检查是否对教学班进行初始化
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要查看的教学班编号：（输入 q 退出）");

        String input = scanner.next();

        if (input.equalsIgnoreCase("q")) {
            return; // 退出循环
        }

        for (TeachingClass teachingClass : teachingClasses) {
            if (String.valueOf(teachingClass.getId()).equals(input)) {
                System.out.println(teachingClass);
                waitForUser();
                return;
            }
        }

        System.out.println("未找到该教学班，请检查输入是否正确。");
        waitForUser();
        showTeachingClass();
    }

    // 添加教学班学生
    public static void addStudentToTeachingClass () {
        if (checkTeachingClass()) { // 检查是否对教学班进行初始化
            return;
        }
        System.out.println("请输入要添加学生的教学班编号：（输入 q 退出）");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        if (input.equalsIgnoreCase("q")) {
            return; // 退出循环
        }

        for (TeachingClass teachingClass : teachingClasses) {
            if (String.valueOf(teachingClass.getId()).equals(input)) {
                System.out.println("请输入要添加的学生学号：（输入 q 退出）");
                input = scanner.next();

                if (input.equalsIgnoreCase("q")) {
                    return; // 退出循环
                }

                for (Student student : students) {
                    if (student.getId().equals(input)) {
                        if (teachingClass.getStudents().contains(student)) {
                            System.out.println("该学生已经在该教学班中！");
                            waitForUser();
                            return;
                        }

                        if (studentScores.get(student).containsKey(teachingClass.getCourse())) {
                            System.out.println("该学生已经选择了该门课程！");
                            waitForUser();
                            return;
                        }

                        teachingClass.getStudents().add(student);
                        teachingClass.getClassScore().getScores().put(student, new CourseScore());
                        studentScores.get(student).put(teachingClass.getCourse(), new CourseScore());
                        return;
                    }
                }
            }
        }

        System.out.println("教学班不存在，请重新输入！");
        waitForUser();
        addStudentToTeachingClass();
    }

    // 删除教学班学生
    public static void deleteStudentFromTeachingClass () {
        if (checkTeachingClass()) { // 检查是否对教学班进行初始化
            return;
        }
        System.out.println("请输入要删除学生的教学班编号：（输入 q 退出）");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        if (input.equalsIgnoreCase("q")) {
            return; // 退出循环
        }

        for (TeachingClass teachingClass : teachingClasses) {
            if (String.valueOf(teachingClass.getId()).equals(input)) {
                System.out.println("请输入要删除的学生学号：（输入 q 退出）");
                input = scanner.next();

                if (input.equalsIgnoreCase("q")) {
                    return; // 退出循环
                }

                for (Student student : students) {
                    if (student.getId().equals(input)) {
                        if (teachingClass.getStudents().contains(student)) {
                            teachingClass.getStudents().remove(student);
                            teachingClass.getClassScore().getScores().remove(student);
                            studentScores.get(student).remove(teachingClass.getCourse());
                            System.out.println("该学生删除成功。");
                            waitForUser();
                            return;
                        }
                    }
                }
                System.out.println("该学生不在该教学班中，请重新输入！");
                return;
            }
        }

        System.out.println("教学班不存在，请重新输入！");
        waitForUser();
        deleteStudentFromTeachingClass();
    }

    // 随机生成教学班学生成绩
    public static void createClassScore() {
        if (checkTeachingClass()) { // 检查是否对教学班进行初始化
            return;
        }

        System.out.println("请输入要生成成绩的教学班编号：（输入 q 退出）");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        if (input.equalsIgnoreCase("q")) {
            return; // 退出循环
        }

        TeachingClass teachingClass = null;

        for (TeachingClass tc : teachingClasses) {
            if (String.valueOf(tc.getId()).equals(input)) {
                teachingClass = tc;
            }
        }

        if (teachingClass == null) {
            System.out.println("教学班不存在，请重新输入！");
            waitForUser();
            createClassScore();
            return;
        }

        System.out.println("请输入要生成的成绩类型：");
        System.out.println("1. 平时成绩");
        System.out.println("2. 期中成绩");
        System.out.println("3. 实验成绩");
        System.out.println("4. 期末成绩");
        System.out.println("5. 退出");

        int choice = scanner.nextInt();

        if (choice == 5) {
            return;
        }

        LocalDate now = LocalDate.now();
        for (Student student : teachingClass.getStudents()) {
            CourseScore courseScore = teachingClass.getClassScore().getScores().get(student);
            switch (choice) {
                case 1: {
                    courseScore.setRegularScore(random.nextInt(41) + 60); // 随机生成平时成绩
                    courseScore.setRegularScoreDate(now); // 记录成绩获取的时间
                    studentScores.get(student).get(teachingClass.getCourse()).setRegularScore(courseScore.getRegularScore());
                    break;
                }
                case 2: {
                    courseScore.setMidtermScore(random.nextInt(41) + 60); // 随机生成期中成绩
                    courseScore.setMidtermScoreDate(now); // 记录成绩获取的时间
                    studentScores.get(student).get(teachingClass.getCourse()).setMidtermScore(courseScore.getMidtermScore());
                    break;
                }
                case 3: {
                    courseScore.setExperimentScore(random.nextInt(41) + 60); // 随机生成实验成绩
                    courseScore.setExperimentScoreDate(now); // 记录成绩获取的时间
                    studentScores.get(student).get(teachingClass.getCourse()).setExperimentScore(courseScore.getExperimentScore());
                    break;
                }
                case 4: {
                    courseScore.setFinalScore(random.nextInt(41) + 60); // 随机生成期末成绩
                    courseScore.setFinalScoreDate(now); // 记录成绩获取的时间
                    studentScores.get(student).get(teachingClass.getCourse()).setFinalScore(courseScore.getFinalScore());
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    // 随机生成所有教学班学生成绩
    public static void createAllClassScore() {
        if (checkTeachingClass()) { // 检查是否对教学班进行初始化
            return;
        }

        LocalDate now = LocalDate.now();
        for (TeachingClass teachingClass : teachingClasses) {
            for (Student student : teachingClass.getStudents()) {
                CourseScore courseScore = teachingClass.getClassScore().getScores().get(student);
                courseScore.setRegularScore(random.nextInt(41) + 60); // 随机生成平时成绩
                courseScore.setRegularScoreDate(now); // 记录成绩获取的时间
                studentScores.get(student).get(teachingClass.getCourse()).setRegularScore(courseScore.getRegularScore());

                courseScore.setMidtermScore(random.nextInt(41) + 60); // 随机生成期中成绩
                courseScore.setMidtermScoreDate(now); // 记录成绩获取的时间
                studentScores.get(student).get(teachingClass.getCourse()).setMidtermScore(courseScore.getMidtermScore());

                courseScore.setExperimentScore(random.nextInt(41) + 60); // 随机生成实验成绩
                courseScore.setExperimentScoreDate(now); // 记录成绩获取的时间
                studentScores.get(student).get(teachingClass.getCourse()).setExperimentScore(courseScore.getExperimentScore());

                courseScore.setFinalScore(random.nextInt(41) + 60); // 随机生成期末成绩
                courseScore.setFinalScoreDate(now); // 记录成绩获取的时间
                studentScores.get(student).get(teachingClass.getCourse()).setFinalScore(courseScore.getFinalScore());

                studentScores.get(student).get(teachingClass.getCourse()).calculateTotalScore(teachingClass.getCourse().getRegularScoreWeight(), teachingClass.getCourse().getMidtermScoreWeight(),
                                                teachingClass.getCourse().getExperimentScoreWeight(), teachingClass.getCourse().getFinalScoreWeight());

            }
        }

        System.out.println("所有教学班成绩已生成！");
        waitForUser();
    }

    // 查看教学班所有学生成绩
    public static void showTeachingClassScores() {
        if (checkTeachingClass()) { // 检查是否对教学班进行初始化
            return;
        }
        System.out.println("请输入要查看的教学班编号：（输入 q 退出）");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        if (input.equalsIgnoreCase("q")) {
            return; // 退出循环
        }

        for (TeachingClass teachingClass : teachingClasses) {
            if (String.valueOf(teachingClass.getId()).equals(input)) {
                if (teachingClass.getClassScore().getScores().isEmpty()) {
                    System.out.println("教学班成绩为空, 请先初始化成绩！");
                    waitForUser();
                    return;
                }

                for(Student student : teachingClass.getStudents()) {
                    showScores(teachingClass, student);
                }

                waitForUser();
                return;
            }
        }

        System.out.println("教学班不存在，请重新输入！");
        waitForUser();
        showTeachingClassScores();
    }

    // 查看教学班单个学生成绩
    public static void showStudentScoresInClass() {
        if (checkTeachingClass()) { // 检查是否对教学班进行初始化
            return;
        }
        System.out.println("请输入要查看的教学班编号：（输入 q 退出）");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        if (input.equalsIgnoreCase("q")) {
            return; // 退出循环
        }

        for (TeachingClass teachingClass : teachingClasses) {
            if (String.valueOf(teachingClass.getId()).equals(input)) {
                if (teachingClass.getClassScore().getScores().isEmpty()) {
                    System.out.println("教学班成绩为空, 请先初始化成绩！");
                    waitForUser();
                    return;
                }

                System.out.println("请输入要查看的学生学号：（输入 q 退出）");

                input = scanner.next();

                if (input.equalsIgnoreCase("q")) {
                    return; // 退出循环
                }

                for(Student student : teachingClass.getStudents()) {
                    if (student.getId().equalsIgnoreCase(input)) {
                        showScores(teachingClass, student);
                        waitForUser();
                        return;
                    }
                }

                System.out.println("学生不存在，请重新输入！");
                waitForUser();
                return;
            }
        }

        System.out.println("教学班不存在，请重新输入！");
        waitForUser();
        showTeachingClassScores();
    }

    public static void showScores(TeachingClass teachingClass, Student student) {
        System.out.println("学生姓名：" + student.getName());
        System.out.println("学生学号：" + student.getId());
        System.out.println("平时成绩：" + teachingClass.getClassScore().getScores().get(student).getRegularScore());
        System.out.println("期中成绩：" + teachingClass.getClassScore().getScores().get(student).getMidtermScore());
        System.out.println("实验成绩：" + teachingClass.getClassScore().getScores().get(student).getExperimentScore());
        System.out.println("期末成绩：" + teachingClass.getClassScore().getScores().get(student).getFinalScore());
        System.out.println("总成绩：" + teachingClass.getClassScore().getScores().get(student).getTotalScore());
        System.out.println("====================================");
    }

    // 检查是否对教学班进行初始化
    public static boolean checkTeachingClass() {
        if (teachingClasses.isEmpty()) {
            System.out.println("请先初始化教学班！");
            waitForUser();
            return true;
        }
        return false;
    }

}
