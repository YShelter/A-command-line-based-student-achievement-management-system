package utilClass;

import mainClass.*;

import java.util.*;

import static utilClass.SystemInfoManager.studentScores;
import static utilClass.Utils.*;

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
        ClassScore cs = new ClassScore(new HashMap<>());
        HashSet<Integer> studentSet = new HashSet<>();
        HashSet<Integer> courseSet = new HashSet<>();
        int courseID = 0;


        for (int i = 0; i < courseNum; i++) {

            int courseIndex = random.nextInt(COURSES.length);
            while (courseSet.contains(courseNum)) { // 对课程名单进行去重
                courseIndex = random.nextInt(COURSES.length);
            }
            courseSet.add(courseIndex);

            for (int j = 0; j < COURSES[courseIndex].getTeachers().size(); j++) { // 遍历课程中的教师
                int studentNum = random.nextInt(11) + 20; // 随机选择一个班级人数
                ArrayList<Student> studentList = new ArrayList<>();

                for (int k = 0; k < studentNum; k++) {
                    int student = random.nextInt(students.size()); // 随机选择一个学生

                    while (studentSet.contains(student)) { // 对学生名单进行去重
                        student = random.nextInt(students.size());
                    }
                    studentSet.add(student);

                    studentList.add(students.get(student)); // 添加学生
                    cs.getScores().put(students.get(student), new CourseScore()); // 添加学生成绩

                    HashMap<Course, CourseScore> studentScore = new HashMap<>();
                    studentScore.put(COURSES[courseIndex], new CourseScore());

                    studentScores.put(students.get(student),studentScore); // 添加学生成绩
                }
                String semester = SEMESTERS[random.nextInt(SEMESTERS.length)]; // 随机选择一个学年学期
                TeachingClass tc = new TeachingClass(courseID, COURSES[courseIndex], COURSES[courseIndex].getTeachers().get(j), studentList, semester, cs);
                teachingClasses.add(tc); // 添加教学班
                courseID++;
            }

            studentSet.clear(); // 清空学生名单

        }

//        for (TeachingClass teachingClass : teachingClasses) {
//            System.out.println(teachingClass);
//            System.out.println("====================================");
//        }
    }

    // 生成教学班学生成绩
    public static void createClassScore(TeachingClass teachingClass,int choice) {
        for (Student student : teachingClass.getStudents()) {
            CourseScore courseScore = teachingClass.getClassScore().getScores().get(student);
            switch(choice) {
                case 1: {
                    courseScore.setRegularScore(random.nextInt(41) + 60); // 随机生成平时成绩
                    break;
                }
                case 2: {
                    courseScore.setMidtermScore(random.nextInt(41) + 60); // 随机生成期中成绩
                    break;
                }
                case 3: {
                    courseScore.setExperimentScore(random.nextInt(41) + 60); // 随机生成实验成绩
                    break;
                }
                case 4: {
                    courseScore.setFinalScore(random.nextInt(41) + 60); // 随机生成期末成绩
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    // 为教学班单独添加学生
    public static void addStudentForClass(TeachingClass teachingClass, ArrayList<Student> students) {
        HashMap<Student, CourseScore> scores = new HashMap<>();
        for (Student student : students) {
            scores.put(student, new CourseScore());
        }

        teachingClass.getStudents().addAll(students);
        teachingClass.getClassScore().getScores().putAll(scores);
    }

}
