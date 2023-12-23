//package com.example.task_management;
//import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.stage.Stage;
//
//public class TaskManagerApp extends Application {
//
//    @FXML
//    private ListView<Task> listView;
//
//    @FXML
//    private RadioButton homeworkRadio;
//
//    @FXML
//    private RadioButton meetingRadio;
//
//    @FXML
//    private RadioButton shoppingRadio;
//
//    @FXML
//    private TextField nameTextField;
//
//    @FXML
//    private TextArea descriptionTextArea;
//
//    @FXML
//    private ComboBox<Priority> priorityComboBox;
//
//    @FXML
//    private Label selectedText;
//
//    private ObservableList<Task> tasks = FXCollections.observableArrayList();
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("TaskManager.fxml"));
//        primaryStage.setTitle("Task Manager");
//        primaryStage.setScene(new Scene(root, 600, 400));
//        primaryStage.show();
//    }
//
//    @FXML
//    public void initialize() {
//        // Initialize the ComboBox with priority values
//        priorityComboBox.getItems().addAll(Priority.values());
//
//        // Initialize the ListView
//        listView.setItems(tasks);
//
//        // Set a listener for selection changes in the ListView
//        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue != null) {
//                selectedText.setText(newValue.toString());
//            }
//        });
//    }
//
//    @FXML
//    protected void onAddTaskClicked() {
//        // Get values from the input fields
//        String name = nameTextField.getText();
//        String description = descriptionTextArea.getText();
//        Priority priority = priorityComboBox.getValue();
//
//        // Validate input
//        if (name.isEmpty() || description.isEmpty() || priority == null) {
//            // Show an alert for incomplete input
//            showAlert("Incomplete Input", "Please fill in all fields.");
//            return;
//        }
//
//        // Create a new task based on the selected radio button
//        Task newTask = createTask(name, description, priority);
//        tasks.add(newTask);
//
//        // Clear input fields
//        nameTextField.clear();
//        descriptionTextArea.clear();
//        priorityComboBox.getSelectionModel().clearSelection();
//    }
//
//    @FXML
//    protected void onMarkAsCompletedClicked() {
//        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
//
//        if (selectedIndex != -1) {
//            // Mark the selected task as completed
//            Task selectedTask = tasks.get(selectedIndex);
//            selectedTask.markAsComplete();
//
//            // Remove the completed task from the list
//            tasks.remove(selectedIndex);
//
//            // Clear the selected text label
//            selectedText.setText("");
//        } else {
//            showAlert("No Task Selected", "Please select a task to mark as completed.");
//        }
//    }
//
//    private void showAlert(String title, String content) {
//        Alert alert = new Alert(Alert.AlertType.WARNING);
//        alert.setTitle(title);
//        alert.setContentText(content);
//        alert.showAndWait();
//    }
//
//    private Task createTask(String taskName, String taskDescription, Priority priority) {
//        if (homeworkRadio.isSelected()) {
//            // Pass the required arguments to the HomeworkTask constructor
//            return new HomeworkTask(taskName, taskDescription, priority, deadline);
//        } else if (meetingRadio.isSelected()) {
//            // Adjust as needed for MeetingTask
//        } else if (shoppingRadio.isSelected()) {
//            // Adjust as needed for ShoppingTask
//        } else {
//            // Default to HomeworkTask if no radio button is selected
//            return new HomeworkTask(taskName, taskDescription, priority, deadline);
//        }
//        return new HomeworkTask(taskName, taskDescription, priority, deadline);
//    }
//
//}
//
