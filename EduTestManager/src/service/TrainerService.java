package service;

import model.Question;
import model.Test;
import repository.QuestionRepository;
import repository.TestRepository;

import java.util.*;
import java.util.stream.Collectors;

public class TrainerService {
    private TestRepository testRepository;
    private QuestionRepository questionRepository;

    public TrainerService(TestRepository testRepository, QuestionRepository questionRepository) {
        this.testRepository = testRepository;
        this.questionRepository = questionRepository;
    }

    public void assignTest(int trainerId, int numQuestions, int numPreviousTests, int testId) {
        List<Test> previousTests = testRepository.getAllTests().stream()
                .sorted((a, b) -> Integer.compare(b.getTestId(), a.getTestId()))
                .limit(numPreviousTests)
                .collect(Collectors.toList());

        Set<Integer> excludedQuestionIds = new HashSet<>();
        for (Test test : previousTests) {
            for (Question question : test.getQuestions()) {
                excludedQuestionIds.add(question.getId());
            }
        }

        List<Question> availableQuestions = questionRepository.viewQuestions().stream()
                .filter(q -> !excludedQuestionIds.contains(q.getId()))
                .collect(Collectors.toList());

        if (availableQuestions.size() < numQuestions) {
            throw new IllegalArgumentException("Not enough questions to assign for the test");
        }

        Collections.shuffle(availableQuestions);
        List<Question> selectedQuestions = availableQuestions.subList(0, numQuestions);

        Test test = new Test();
        test.setTestId(testId);
        test.setTrainerId(trainerId);
        test.setQuestions(selectedQuestions);

        testRepository.addTest(test);
    }

    public void viewScores(int testId) {
        Test test = testRepository.getTestById(testId);
        if (test != null) {
            test.getStudentScores().forEach((studentId, score) ->
                    System.out.println("Student ID: " + studentId + ", Score: " + score));
        }
    }
}