package repository;

import model.Question;

import java.util.List;

public interface QuestionRepository {
    void addQuestion(Question question);
    void deleteQuestion(int questionId);
    List<Question> viewQuestions();
    Question getQuestionById(int questionId);
}
