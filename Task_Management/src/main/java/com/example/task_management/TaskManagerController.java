//package com.example.task_management;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//
//import static javafx.application.Application.launch;
//
//public class TaskManagerController {
//    @FXML
//    private ToggleGroup taskTypeToggleGroup; // Placeholder for the actual ToggleGroup
//
//    @FXML
//    private ListView<Task> listView;
//    @FXML
//    private TextField taskNameField;
//    @FXML
//    private TextField taskDescriptionField;
//    @FXML
//    private ComboBox<Priority> priorityComboBox;
//
//    private ObservableList<Task> tasks = FXCollections.observableArrayList();
//
//    @FXML
//    public void initialize() {
//        listView.setItems(tasks);
//        priorityComboBox.setItems(FXCollections.observableArrayList(Priority.values()));
//    }
//
//    @FXML
//    public void addTask() {
//        Task newTask = createTaskFromInput();
//        // Add the task
//        tasks.add(newTask);
//        //clear input
//        clearInputFields();
//    }
//
//    @FXML
//    public void markAsComplete() {
//        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
//        if (selectedIndex >= 0) {
//            // Mark the selected task as complete
//            tasks.get(selectedIndex).markAsComplete();
//            // Remove the completed task from the list
//            tasks.remove(selectedIndex);
//        }
//    }
//
//    private Task createTaskFromInput() {
//        String taskName = taskNameField.getText();
//        String taskDescription = taskDescriptionField.getText();
//        Priority priority = priorityComboBox.getValue();
//
//        Toggle selectedToggle = taskTypeToggleGroup.getSelectedToggle();
//        String selectedTaskType = selectedToggle.getUserData().toString();
//
//        Task newTask = null;
//        switch (selectedTaskType) {
//            case "Homework":
//                // Pass the required arguments to the HomeworkTask constructor
//                newTask = new HomeworkTask( taskName, taskDescription, priority, deadline);
//                break;
//            case "Meeting":
//                // Adjust as needed for MeetingTask
//                newTask = new MeetingTask(taskName, taskDescription, priority);
//                break;
//            case "Shopping":
//                // Adjust as needed for ShoppingTask
//                newTask = new ShoppingTask(taskName, taskDescription, priority);
//                break;
//            // Add more cases for additional task types if needed
//        }
//
//
//        if (newTask != null) {
//            // Set common properties for all task types
//            newTask.setTask(taskName, taskDescription);
//            newTask.setPriority(priority);
//
//            // Set specific properties based on the task type (You need to implement these methods in each task class)
////            if (newTask instanceof HomeworkTask) {
////                // Set HomeworkTask-specific properties
////                ((HomeworkTask) newTask).setTask();
////            } else if (newTask instanceof MeetingTask) {
////                // Set MeetingTask-specific properties
////                ((MeetingTask) newTask).setMeetingSpecificProperty(/* value */);
////            } else if (newTask instanceof ShoppingTask) {
////                // Set ShoppingTask-specific properties
////                ((ShoppingTask) newTask).setShoppingSpecificProperty(/* value */);
////            }
//        }
//
//        return newTask;
//    }
//
//    private void clearInputFields() {
//        taskNameField.clear();
//        taskDescriptionField.clear();
//        priorityComboBox.getSelectionModel().clearSelection();
//    }
//
//}
