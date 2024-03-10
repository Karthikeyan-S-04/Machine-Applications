package service.implementation;

import repository.TaskRepository;
import repository.implementation.TaskRepositoryImpl;
import service.TaskManager;
import java.util.*;

public class TaskManagerImpl implements TaskManager {
    Scanner scanner = new Scanner(System.in);
    private int taskId = 1;
    TaskRepository taskRepository = new TaskRepositoryImpl();
    @Override
    public void add() {
        String title;
        String completed = "Not Completed";
        System.out.println();
        System.out.print("Title : ");
        title = scanner.nextLine();
        System.out.print("Description : ");
        String description = scanner.nextLine();
        System.out.print("Category : ");
        String category = scanner.nextLine();
        System.out.print("Priority Level : ");
        int priority = scanner.nextInt();
        scanner.nextLine();
        taskRepository.addTask(taskId++,category,title,description,priority,completed);
    }

    @Override
    public void displayDetails() {
        taskRepository.display();
    }

    @Override
    public void mark(int n) {
        taskRepository.mark(n);
    }

    @Override
    public void deleteTask(int n) {
        taskRepository.delete(n);
    }
}
