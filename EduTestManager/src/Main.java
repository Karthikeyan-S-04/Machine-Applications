import controller.AdminController;
import controller.StudentController;
import controller.TrainerController;
import repository.implementation.InMemoryQuestionRepository;
import repository.implementation.InMemoryTestRepository;
import service.AdminService;
import service.StudentService;
import service.TrainerService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InMemoryQuestionRepository questionRepository = new InMemoryQuestionRepository();
        InMemoryTestRepository testRepository = new InMemoryTestRepository();

        AdminService adminService = new AdminService(questionRepository);
        TrainerService trainerService = new TrainerService(testRepository, questionRepository);
        StudentService studentService = new StudentService(testRepository);

        AdminController adminController = new AdminController(adminService);
        TrainerController trainerController = new TrainerController(trainerService);
        StudentController studentController = new StudentController(studentService);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select role: 1. Admin 2. Trainer 3. Student 4. Exit");
            int role = scanner.nextInt();

            switch (role) {
                case 1:
                    System.out.println("Admin actions: 1. Add Question 2. Delete Question 3. View Questions 4. Back");
                    int adminAction = scanner.nextInt();
                    switch (adminAction) {
                        case 1:
                            adminController.addQuestion();
                            break;
                        case 2:
                            adminController.deleteQuestion();
                            break;
                        case 3:
                            adminController.viewQuestions();
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid action");
                    }
                    break;

                case 2:
                    System.out.println("Trainer actions: 1. Assign Test 2. View Scores 3. Back");
                    int trainerAction = scanner.nextInt();
                    switch (trainerAction) {
                        case 1:
                            trainerController.assignTest();
                            break;
                        case 2:
                            trainerController.viewScores();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Invalid action");
                    }
                    break;

                case 3:
                    System.out.println("Student actions: 1. Take Test 2. View Score 3. Back");
                    int studentAction = scanner.nextInt();
                    switch (studentAction) {
                        case 1:
                            studentController.takeTest();
                            break;
                        case 2:
                            studentController.viewScore();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Invalid action");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid role");
            }
        }
    }
}