package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    private int testId;
    private int trainerId;
    private List<Question> questions;
    private Map<Integer, Integer> studentScores  = new HashMap<>();; // studentId -> score

    // Getters and Setters
    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Map<Integer, Integer> getStudentScores() {
        return studentScores;
    }

    public void setStudentScores(Map<Integer, Integer> studentScores) {
        this.studentScores = studentScores;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testId=" + testId +
                ", trainerId=" + trainerId +
                ", questions=" + questions +
                ", studentScores=" + studentScores +
                '}';
    }
}