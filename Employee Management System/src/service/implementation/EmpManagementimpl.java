package service.implementation;

import repository.EmpRepo;
import repository.implementation.EmpRepoimpl;
import service.EmpManagement;

import java.util.Scanner;

public class EmpManagementimpl implements EmpManagement {
    Scanner scanner = new Scanner(System.in);
    EmpRepo empRepo = new EmpRepoimpl();
    @Override
    public void add() {
        String attendance = "Absent";
        System.out.print("Enter the Employee ID : ");
        String emp_id = scanner.nextLine();
        System.out.print("Enter the Name : ");
        String name = scanner.nextLine();
        System.out.print("Enter the Position : ");
        String pos = scanner.nextLine();
        empRepo.add(emp_id,name,pos,attendance);
    }

    @Override
    public void display() {
        empRepo.display();
    }

    @Override
    public void edit(int ed, String edi, String edit_id) {
        empRepo.edit(ed,edi,edit_id);
    }

    @Override
    public void delete(String del) {
        empRepo.delete(del);
    }

    @Override
    public void attendance(String[] s) {
        empRepo.attendance(s);
    }

    @Override
    public void search(int ed, String edi) {
        empRepo.search(ed,edi);
    }
}
