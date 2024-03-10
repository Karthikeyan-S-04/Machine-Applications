package repository;

public interface TaskRepository {
    void addTask(int taskId,String category, String title, String description, int priority, String completed);
    void display();
    void mark(int comp);
    void delete(int del_id);
}
