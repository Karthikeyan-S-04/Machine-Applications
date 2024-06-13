package controller;

import service.TrainerService;

import java.util.Scanner;

public class TrainerController {
    private TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    public void assignTest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter trainer ID:");
        int trainerId = scanner.nextInt();
        System.out.println("Enter test ID:");
        int testId = scanner.nextInt();
        System.out.println("Enter number of questions:");
        int numQuestions = scanner.nextInt();
        System.out.println("Enter number of previous tests to exclude questions from:");
        int numPreviousTests = scanner.nextInt();

        try {
            trainerService.assignTest(trainerId, numQuestions, numPreviousTests, testId);
            System.out.println("Test assigned successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void viewScores() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter test ID to view scores:");
        int testId = scanner.nextInt();

        trainerService.viewScores(testId);
    }
}