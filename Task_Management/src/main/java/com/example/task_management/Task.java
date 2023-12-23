package com.example.task_management;

import java.util.Date;

public interface Task {
    void setTask(String taskName, String taskDescription);
    void setTaskName(String taskName);
    void setTaskDescription(String taskDescription);
    void markAsComplete();
    void setPriority(Priority priority);
    void setDeadline(Date date);

    String getDescription(String description);

    void setId(int id);

    String getDescription();

    String getTaskName();

    boolean isCompleted();

    Object getPriority();

    Date getDeadline();

    int getId();
}
