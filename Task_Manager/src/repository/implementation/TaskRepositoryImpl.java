package repository.implementation;

import model.AddTask;
import repository.TaskRepository;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.io.*;
public class TaskRepositoryImpl implements TaskRepository {

    PriorityQueue<AddTask> task = new PriorityQueue<>(1, new Comparator<AddTask>() {
        @Override
        public int compare(AddTask o1, AddTask o2) {
            if(o1.getPriority() > o2.getPriority()){
                return -1;
            }
            else if(o1.getPriority() == o2.getPriority()){
                return 0;
            }
            else{
                return 1;
            }
        }
    });

    @Override
    public void addTask(int taskId, String category, String title, String description,int priority, String completed) {
        AddTask adTask  = new AddTask(taskId, category, title, description,priority,completed);
        task.add(adTask);
    }

    public void display(){
        if(task.isEmpty())
            System.out.println("                      No tasks To Complete");
        for(AddTask adTask : task){
            System.out.println("TaskId                           : "+adTask.getTaskId());
            System.out.println("Category                         : "+adTask.getCategory());
            System.out.println("Title                            : "+adTask.getTitle());
            System.out.println("Description                      : "+adTask.getDescription());
            System.out.println("Priority [1-Low,2-Medium,3-High] : "+adTask.getPriority());
            System.out.println("Completed or Not                 : " +adTask.getCompleted());
            System.out.println();
        }
    }

    @Override
    public void mark(int comp) {
        for(AddTask adTask : task){
            if(comp == adTask.getTaskId()){
                adTask.setCompleted("Completed");
            }
        }
    }

    @Override
    public void delete(int del_num) {
        for (AddTask adTask : task) {
            if (adTask.getTaskId() == del_num) {
                task.remove(adTask);
            }
        }
    }
}
