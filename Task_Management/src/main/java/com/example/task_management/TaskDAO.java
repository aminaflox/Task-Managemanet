package com.example.task_management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    private Connection connect;

    public TaskDAO(){
        String url = "jdbc:postgresql:TaskManagement";
        String username = "postgres";
        String password = "*";

        try{
            this.connect = DriverManager.getConnection(url,username,password);
            System.out.println("Database successfully connected");
        }catch (SQLException e){
            System.out.println(e.toString());
        }
    }

    public void closeConnection(){
        try{
            if (connect != null && !connect.isClosed()){
                connect.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Task getTaskById(int id) {
        String sql = "SELECT * FROM tasks WHERE id = ?";

        try (PreparedStatement statement = connect.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String taskName = resultSet.getString("taskname");
                    String description = resultSet.getString("description");
                    Date deadline = resultSet.getDate("deadline");
                    String priority = resultSet.getString("priority");

                    if (description == null) {
                        description = "No description available";
                    }


                    Task task = new HomeworkTask(taskName, description, Priority.valueOf(priority));
                    task.setId(id);
                    return task;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public void addTask(Task task) {
        String sql = "INSERT INTO tasks (taskname, description, completed, priority) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, task.getTaskName());
            statement.setString(2, task.getDescription());
            statement.setBoolean(3, task.isCompleted());

            // Check if Priority is not null before setting it
            if (task.getPriority() != null) {
                statement.setString(4, task.getPriority().toString());
            } else {
                // Set a default Priority if it's null (you might want to handle this differently)
                statement.setString(4, Priority.LOW.toString());
            }


            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        task.setId(generatedId);
                        System.out.println("Task added successfully with ID: " + generatedId);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void updateTask(Task task) {
        String sql = "UPDATE tasks SET completed=? WHERE id=?";

        try (PreparedStatement statement = connect.prepareStatement(sql)) {
            statement.setBoolean(3, task.isCompleted());
            statement.setInt(6, task.getId());

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Task updated successfully");
            } else {
                System.out.println("Task with ID " + task.getId() + " not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks";

        try (Statement statement = connect.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String taskName = resultSet.getString("taskname");
                String description = resultSet.getString("description");
                Date deadline = resultSet.getDate("deadline");
                String priority = resultSet.getString("priority");

                if (description == null) {
                    description = "No description available";
                }

                Task task = new HomeworkTask(taskName, description, Priority.valueOf(priority));
                task.setId(id);
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tasks;
    }


    public void deleteTask(int taskId) {
        String sql = "DELETE FROM tasks WHERE id=?";

        try (PreparedStatement statement = connect.prepareStatement(sql)) {
            statement.setInt(1, taskId);

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Task with ID " + taskId + " deleted successfully");
            } else {
                System.out.println("Task with ID " + taskId + " not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
