package mainClass;

import java.util.ArrayList;

public class Course {
    private String id; // 课程代码
    private String name; // 课程名称
    private int credit; // 学分
    private ArrayList<Teacher> teachers; // 教师列表
    private double regularScoreWeight = 0.1; // 平时成绩权重
    private double midtermScoreWeight = 0.2; // 期中成绩权重
    private double experimentScoreWeight = 0.3; // 实验成绩权重
    private double finalScoreWeight = 0.4; // 期末成绩权重

    public Course() {
    }

    public Course(String id, String name, int credit) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.teachers = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Course{" +
                "课程代码：" + id + '\t' +
                ", 课程名称:" + name + '\t' +
                ", 课程学分:" + credit + '\n' +
                ", 教师列表" + teachers +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public double getRegularScoreWeight() {
        return regularScoreWeight;
    }

    public void setRegularScoreWeight(double regularScoreWeight) {
        this.regularScoreWeight = regularScoreWeight;
    }

    public double getMidtermScoreWeight() {
        return midtermScoreWeight;
    }

    public void setMidtermScoreWeight(double midtermScoreWeight) {
        this.midtermScoreWeight = midtermScoreWeight;
    }

    public double getExperimentScoreWeight() {
        return experimentScoreWeight;
    }

    public void setExperimentScoreWeight(double experimentScoreWeight) {
        this.experimentScoreWeight = experimentScoreWeight;
    }

    public double getFinalScoreWeight() {
        return finalScoreWeight;
    }

    public void setFinalScoreWeight(double finalScoreWeight) {
        this.finalScoreWeight = finalScoreWeight;
    }
}
