package repository;

public interface EmpRepo {
    void add(String empId, String name, String pos, String attendance);

    void display();
    void edit(int ed, String edi, String editId);

    void delete(String del);

    void search(int ed, String edi);

    void attendance(String[] s);
}
