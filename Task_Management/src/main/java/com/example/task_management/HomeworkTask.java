package com.example.task_management;

import java.util.Date;

public class HomeworkTask implements Task{
    private String taskName, description;
    private boolean complated;
    private Priority priority;
    private Date deadline;

    public HomeworkTask(String taskName, String taskDescription, Priority priority){
        this.taskName=taskName;
        this.description=taskDescription;
        this.priority=priority;
        this.complated=false;
    }


    @Override
    public void setTask(String taskName, String taskDescription) {
        this.taskName = taskName;
        this.description = taskDescription;
        this.complated = false;
    }

    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isCompleted() {
        return false;
    }

    @Override
    public Object getPriority() {
        return this.priority=priority;
    }

    @Override
    public Date getDeadline() {
        return this.deadline=deadline;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void setTaskDescription(String taskDescription) {
        this.description = taskDescription;
    }

    @Override
    public void markAsComplete() {
        this.complated = true;
    }

    @Override
    public void setPriority(Priority priority) {
        this.priority = priority;

    }
    @Override
    public void setDeadline(Date date) {
        this.deadline = date;
    }

    @Override
    public String getDescription(String description) {
        return this.description;
    }

    @Override
    public void setId(int id) {
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    public String toString(){
        return "Task name: " + this.taskName + " " + this.complated +" " + this.priority + " " + this.deadline;
    }
}
