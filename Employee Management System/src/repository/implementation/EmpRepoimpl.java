package repository.implementation;

import model.EmpDetails;
import repository.EmpRepo;

import java.util.ArrayList;
import java.util.Objects;

public class EmpRepoimpl implements EmpRepo {
    ArrayList<EmpDetails> emp = new ArrayList<>();
    @Override
    public void add(String empId, String name, String pos, String attendance) {
        EmpDetails addEmp = new EmpDetails(empId, name, pos, attendance);
        emp.add(addEmp);
    }

    @Override
    public void display() {
        System.out.println();
        if(emp.isEmpty())
            System.out.println("No Employee Details Available");
        for (EmpDetails details : emp){
            System.out.println("Employee ID : "+details.getEmpId());
            System.out.println("Name        : "+details.getName());
            System.out.println("Position    : "+details.getPos());
            System.out.println("Attendance  : "+details.getAttendance());
            System.out.println();
        }
    }

    @Override
    public void edit(int ed, String edi, String edit_id) {
        if(ed == 1){
            for(EmpDetails details : emp){
                if(Objects.equals(edit_id, details.getName())){
                    details.setName(edi);
                }
            }
        } else if (ed == 2) {
            for(EmpDetails details : emp){
                if(Objects.equals(edit_id, details.getPos())){
                    details.setPos(edi);
                }
            }
        }
    }

    @Override
    public void delete(String del) {
        emp.removeIf(details -> Objects.equals(details.getEmpId(), del));
    }

    @Override
    public void search(int ed, String edi) {
        System.out.println();
        if(emp.isEmpty())
            System.out.println("No Employee Details Available");
        else
        if(ed == 1){
            for(EmpDetails details : emp){
                if(Objects.equals(edi, details.getName())){
                    System.out.println("Employee ID : "+details.getEmpId());
                    System.out.println("Name        : "+details.getName());
                    System.out.println("Position    : "+details.getPos());
                    System.out.println("Attendance  : "+details.getAttendance());
                    System.out.println();
                }
            }
        } else if (ed == 2) {
            for(EmpDetails details : emp){
                if(Objects.equals(edi, details.getPos())){
                    System.out.println("Employee ID : "+details.getEmpId());
                    System.out.println("Name        : "+details.getName());
                    System.out.println("Position    : "+details.getPos());
                    System.out.println("Attendance  : "+details.getAttendance());
                    System.out.println();
                }
            }
        }
        if(ed == 3){
            for(EmpDetails details : emp){
                if(Objects.equals(edi, details.getEmpId())){
                    System.out.println("Employee ID : "+details.getEmpId());
                    System.out.println("Name        : "+details.getName());
                    System.out.println("Position    : "+details.getPos());
                    System.out.println("Attendance  : "+details.getAttendance());
                    System.out.println();
                }
            }
        }
    }

    @Override
    public void attendance(String[] s) {
        for(EmpDetails details : emp){
            for(String str : s) {
                if(details.getEmpId().contains(str)){
                    details.setAttendance("Present");
                }
            }
        }
    }
}
