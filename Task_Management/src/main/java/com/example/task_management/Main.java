package com.example.task_management;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskDAO taskDAO = new TaskDAO();

        int taskIdToRetrieve = 1;
        Task retrievedTask = taskDAO.getTaskById(taskIdToRetrieve);

        if (retrievedTask != null) {
            System.out.println("Task retrieved by ID:" + taskIdToRetrieve);
            System.out.println(retrievedTask);

            String description = retrievedTask.getDescription();
            System.out.println("Task Description: " + description);
        } else {
            System.out.println("Task not found for ID: " + taskIdToRetrieve);
        }

        // READ: Retrieve all tasks
        List<Task> allTasks = taskDAO.getAllTasks();
        System.out.println("\nAll Tasks:");
        for (Task task : allTasks) {
            System.out.println(task);
        }

        System.out.println("\n");
        // CREATE: Add a new task
        Task newTask;
        newTask = new HomeworkTask("New Task 2", "Testing create operation", Priority.MEDIUM);
        taskDAO.addTask(newTask);

        // DELETE: Delete a task by ID
        int taskIdToDelete = 6;
        taskDAO.deleteTask(taskIdToDelete);

        // Closing the database connection
        taskDAO.closeConnection();
    }


}
