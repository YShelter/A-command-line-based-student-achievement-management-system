package mainClass;

public class CourseScore { // 课程成绩
    private int regularScore; // 平时成绩
    private int midtermScore; // 期中成绩
    private int experimentScore; // 实验成绩
    private int finalScore; // 期末成绩
    private int totalScore; // 总成绩

    public CourseScore() {

    }

    public CourseScore(int regularScore, int midtermScore, int experimentScore, int finalScore) {
        this.regularScore = regularScore;
        this.midtermScore = midtermScore;
        this.experimentScore = experimentScore;
        this.finalScore = finalScore;
    }

    public void calculateTotalScore(int regularScoreWeight, int midtermScoreWeight, int experimentScoreWeight, int finalScoreWeight) { // 计算总成绩
        totalScore = (int) (regularScore * regularScoreWeight + midtermScore * midtermScoreWeight +
                            experimentScore * experimentScoreWeight + finalScore * finalScoreWeight);
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

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "CourseScore{" +
                "regularScore=" + regularScore +
                ", midtermScore=" + midtermScore +
                ", experimentScore=" + experimentScore +
                ", finalScore=" + finalScore +
                '}';
    }
}
