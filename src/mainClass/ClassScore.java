package mainClass;

import java.util.HashMap;

public class ClassScore { //教学班成绩管理
    private HashMap<Student, CourseScore> scores; //学生成绩

    public ClassScore() {
    }

    public ClassScore(HashMap<Student, CourseScore> scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "ClassScore{" +
                "scores=" + scores +
                '}';
    }

    public HashMap<Student, CourseScore> getScores() {
        return scores;
    }

    public void setScores(HashMap<Student, CourseScore> scores) {
        this.scores = scores;
    }
}
