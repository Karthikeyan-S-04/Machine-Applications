package model;

public class AddTask {
    public AddTask(int taskId, String category, String title, String description, int priority, String completed) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.taskId = taskId;
        this.priority = priority;
        this.completed = completed;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    private String completed;
    public int getTaskId() {
        return taskId;
    }

    private final int taskId;
    private final String title;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    private final String description;

    public int getPriority() {
        return priority;
    }

    private final int priority;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private String category;
}
