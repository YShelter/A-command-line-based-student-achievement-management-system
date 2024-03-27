package utilClass;

import mainClass.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

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
        HashSet<Integer> studentSet = new HashSet<>();
        HashSet<Integer> courseSet = new HashSet<>();
        int courseID = 0;


        for (int i = 0; i < courseNum; i++) {

            int courseIndex = random.nextInt(COURSES.length);
            while (courseSet.contains(courseNum)) { // 对课程名单进行去重
                courseIndex = random.nextInt(COURSES.length);
            }
            courseSet.add(courseIndex);

            courses.add(COURSES[courseIndex]);// 向开课列表中添加课程

            for (int j = 0; j < COURSES[courseIndex].getTeachers().size(); j++) { // 遍历课程中的教师
                int studentNum = random.nextInt(11) + 20; // 随机选择一个班级人数
                ArrayList<Student> studentList = new ArrayList<>();

                for (int k = 0; k < studentNum; k++) {
                    int student; // 随机选择一个学生

                    while (true) { // 对学生名单进行去重
                        student = random.nextInt(students.size());

                        if (studentSet.contains(student)) {
                            continue;
                        }

                        if (studentScores.get(students.get(student)).containsKey(COURSES[courseIndex])) { // 判断学生是否选择了同一门课程的不同班级
                            continue;
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

    // 随机生成教学班学生成绩
    public static void createClassScore(TeachingClass teachingClass, int choice) {
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

}
