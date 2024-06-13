package repository.implementation;

import model.Question;
import repository.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryQuestionRepository implements QuestionRepository {
    private List<Question> questions = new ArrayList<>();

    @Override
    public void addQuestion(Question question) {
        questions.add(question);
    }

    @Override
    public void deleteQuestion(int questionId) {
        questions.removeIf(q -> q.getId() == questionId);
    }

    @Override
    public List<Question> viewQuestions() {
        return questions;
    }

    @Override
    public Question getQuestionById(int questionId) {
        return questions.stream().filter(q -> q.getId() == questionId).findFirst().orElse(null);
    }
}
