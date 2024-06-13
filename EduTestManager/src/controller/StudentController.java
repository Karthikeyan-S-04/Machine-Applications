package controller;

import model.Question;
import model.Test;
import service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public void takeTest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student ID:");
        int studentId = scanner.nextInt();
        System.out.println("Enter test ID:");
        int testId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Test test = studentService.getTestById(testId);
        List<Integer> selectedOptions = new ArrayList<>();

        if (test != null) {
            for (Question question : test.getQuestions()) {
                System.out.println(question.getQuestionText());
                List<String> options = question.getOptions();
                for (int i = 0; i < options.size(); i++) {
                    System.out.println((i + 1) + ". " + options.get(i));
                }
                System.out.println("Select option (1-" + options.size() + "):");
                selectedOptions.add(scanner.nextInt() - 1);
            }
            studentService.takeTest(studentId, testId, selectedOptions);
            System.out.println("Test completed successfully!");
        } else {
            System.out.println("Test not found!");
        }
    }

    public void viewScore() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student ID:");
        int studentId = scanner.nextInt();
        System.out.println("Enter test ID:");
        int testId = scanner.nextInt();

        int score = studentService.viewScore(studentId, testId);
        System.out.println("Your score: " + score);
    }
}