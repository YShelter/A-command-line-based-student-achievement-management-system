package mainClass;

public class CourseScore { // 课程成绩
    int regularScore; // 平时成绩
    int midtermScore; // 期中成绩
    int experimentScore; // 实验成绩
    int finalScore; // 期末成绩

    int calculateTotalScore() { // 计算总成绩
        return (int)(regularScore * 0.1 + midtermScore * 0.2 + experimentScore * 0.3 + finalScore * 0.4);
    }

    public int getRegularScore() {
        return regularScore;
    }

    public void setRegularScore(int regularScore) {
        this.regularScore = regularScore;
    }

    public int getMidtermScore() {
        return midtermScore;
    }

    public void setMidtermScore(int midtermScore) {
        this.midtermScore = midtermScore;
    }

    public int getExperimentScore() {
        return experimentScore;
    }

    public void setExperimentScore(int experimentScore) {
        this.experimentScore = experimentScore;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }
}
