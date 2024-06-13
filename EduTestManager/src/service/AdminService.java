package service;

import model.Question;
import repository.QuestionRepository;

import java.util.List;

public class AdminService {
    private QuestionRepository questionRepository;

    public AdminService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void addQuestion(Question question) {
        questionRepository.addQuestion(question);
    }

    public void deleteQuestion(int questionId) {
        questionRepository.deleteQuestion(questionId);
    }

    public List<Question> viewQuestions() {
        return questionRepository.viewQuestions();
    }
}