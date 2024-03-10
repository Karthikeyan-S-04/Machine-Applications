package controller;
import service.TaskManager;
import service.implementation.TaskManagerImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TaskManager taskManager =  new TaskManagerImpl();

        Scanner sc = new Scanner(System.in);

        application(taskManager,sc);
    }
    private static void description() {
        System.out.println();
        System.out.println("1.Add a task");
        System.out.println("2.Display The tasks");
        System.out.println("3.Mark a task as Completed or not");
        System.out.println("4.Delete a task");
        System.out.println("5.Exit");
    }

    private static void disp() {
        System.out.println();
        System.out.println("                            Task Manager");
        System.out.println();
    }

    private static void application(TaskManager taskManager, Scanner sc) {
        while(true)
        {
            description();
            System.out.println();
            System.out.println("Enter your choice");
            int choice;
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    taskManager.add();
                    break;
                }

                case 2: {
                    disp();
                    taskManager.displayDetails();
                    break;
                }

                case 3: {
                    System.out.println("Enter the task to be Marked as Completed");
                    int number = sc.nextInt();
                    taskManager.mark(number);
                    break;
                }

                case 4: {
                    System.out.println("Enter the task to be deleted");
                    int number = sc.nextInt();
                    taskManager.deleteTask(number);
                    break;
                }

                case 5: {
                    sc.close();
                    return;
                }
            }
        }
    }
}
