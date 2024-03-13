package model;

public class EmpDetails {
    public EmpDetails(String empId, String name, String pos, String attendance) {
        this.empId = empId;
        this.name = name;
        this.pos = pos;
        this.attendance = attendance;
    }

    private final String empId;

    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    private String name;
    private String pos;
    private String attendance;
}
