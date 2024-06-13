package controller;

import model.Question;
import service.AdminService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdminController {
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    public void addQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter question ID:");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.println("Enter question text:");
        String text = scanner.nextLine();
        System.out.println("Enter options (comma separated):");
        String options = scanner.nextLine();
        System.out.println("Enter correct option index:");
        int correctOption = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.println("Enter difficulty level (easy, medium, hard):");
        String difficulty = scanner.nextLine();

        Question question = new Question();
        question.setId(id);
        question.setQuestionText(text);
        question.setOptions(Arrays.asList(options.split(",")));
        question.setCorrectOption(correctOption);
        question.setDifficultyLevel(difficulty);

        adminService.addQuestion(question);
        System.out.println("Question added successfully!");
    }

    public void deleteQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter question ID to delete:");
        int id = scanner.nextInt();

        adminService.deleteQuestion(id);
        System.out.println("Question deleted successfully!");
    }

    public void viewQuestions() {
        List<Question> questions = adminService.viewQuestions();
        for (Question question : questions) {
            System.out.println(question);
        }
    }
}