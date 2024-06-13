package repository.implementation;

import model.Test;
import repository.TestRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTestRepository implements TestRepository {
    private List<Test> tests = new ArrayList<>();

    @Override
    public void addTest(Test test) {
        tests.add(test);
    }

    @Override
    public Test getTestById(int testId) {
        return tests.stream().filter(t -> t.getTestId() == testId).findFirst().orElse(null);
    }

    @Override
    public List<Test> getAllTests() {
        return tests;
    }

    @Override
    public void updateTest(Test test) {
        Test existingTest = getTestById(test.getTestId());
        if (existingTest != null) {
            tests.remove(existingTest);
            tests.add(test);
        }
    }
}