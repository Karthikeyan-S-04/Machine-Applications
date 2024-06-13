package repository;

import model.Test;

import java.util.List;

public interface TestRepository {
    void addTest(Test test);
    Test getTestById(int testId);
    List<Test> getAllTests();
    void updateTest(Test test);
}