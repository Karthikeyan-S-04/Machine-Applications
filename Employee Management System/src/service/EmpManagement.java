package service;

public interface EmpManagement {
    void add();

    void display();

    void edit(int ed, String edi, String edit_id);

    void delete(String del);

    void attendance(String[] s);

    void search(int ed, String edi);
}
