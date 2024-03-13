package controller;
import service.EmpManagement;
import service.implementation.EmpManagementimpl;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EmpManagement empManagement= new EmpManagementimpl();

        application(empManagement,scanner);
    }

    private static void options(){
        System.out.println();
        System.out.println("Employee Management System");
        System.out.println("1.Add a Employee Details");
        System.out.println("2.Display the Employees Details");
        System.out.println("3.Edit a Employee Details");
        System.out.println("4.Delete a Employee Details");
        System.out.println("5.Attendance Tracker");
        System.out.println("6.Search for a Employee");
        System.out.println("Any other Key to Exit");
        System.out.println();
    }
    private static void editD(){
        System.out.println("1.Name");
        System.out.println("2.Position");
    }

    private static void application(EmpManagement empManagement, Scanner scanner) {
        while(true){
            options();
            System.out.println("Enter a Option :");
            int number = scanner.nextInt();
            scanner.nextLine();
            switch (number){
                case 1 : {
                    System.out.println();
                    empManagement.add();
                    break;
                }
                case 2 : {
                    System.out.println("               Employee Management System");
                    empManagement.display();
                    break;
                }
                case 3 : {
                    System.out.println("Enter the Employee Details that need to be edited :");
                    String edit_id = scanner.nextLine();
                    editD();
                    System.out.println("Enter the detail that need to updated");
                    int ed = scanner.nextInt();
                    scanner.nextLine();
                    switch (ed){
                        case 1:{
                            System.out.println("Enter the updated Name");
                            String edi = scanner.nextLine();
                            empManagement.edit(ed,edi,edit_id);
                            break;
                        }
                        case 2:{
                            System.out.println("Enter the updated Position");
                            String edi = scanner.nextLine();
                            empManagement.edit(ed,edi,edit_id);
                            break;
                        }
                    }
                    break;
                }
                case 4 : {
                    System.out.println("Enter the Employee ID of the Employee that needs to be deleted");
                    String del = scanner.nextLine();
                    empManagement.delete(del);
                    break;
                }
                case 5 : {
                    System.out.println("Enter the Employee ID of the Employees that are present");
                    String att = scanner.nextLine();
                    empManagement.attendance(att.split(" "));
                    break;
                }
                case 6 : {
                    editD();
                    System.out.println("3.Employee ID");
                    System.out.println("Enter the option through which search is conducted");
                    int ed = scanner.nextInt();
                    scanner.nextLine();
                    switch (ed){
                        case 3:{
                            System.out.println("Enter the Employee ID");
                            String edi = scanner.nextLine();
                            System.out.println("\nSearch By ID");
                            empManagement.search(ed,edi);
                            break;
                        }
                        case 1:{
                            System.out.println("Enter the Name");
                            String edi = scanner.nextLine();
                            System.out.println("\nSearch By Name");
                            empManagement.search(ed,edi);
                            break;
                        }
                        case 2:{
                            System.out.println("Enter the Position");
                            String edi = scanner.nextLine();
                            System.out.println("\nSearch By Position");
                            empManagement.search(ed,edi);
                            break;
                        }
                    }
                    break;
                }
                default: {
                    scanner.close();
                    return;
                }

            }
        }
    }
}