package service;

import model.Test;
import repository.TestRepository;

import java.util.List;

public class StudentService {
    private TestRepository testRepository;

    public StudentService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public Test getTestById(int testId) {
        return testRepository.getTestById(testId);
    }

    public void takeTest(int studentId, int testId, List<Integer> selectedOptions) {
        Test test = testRepository.getTestById(testId);
        if (test != null) {
            int score = 0;
            for (int i = 0; i < test.getQuestions().size(); i++) {
                if (test.getQuestions().get(i).getCorrectOption() == selectedOptions.get(i)) {
                    score++;
                }
            }
            test.getStudentScores().put(studentId, score);
            testRepository.updateTest(test);
        }
    }

    public int viewScore(int studentId, int testId) {
        Test test = testRepository.getTestById(testId);
        return test != null ? test.getStudentScores().getOrDefault(studentId, 0) : 0;
    }
}