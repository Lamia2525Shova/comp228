package com.opios.studentappinfo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
        import javafx.scene.layout.*;
        import javafx.stage.Stage;

public class Studentappinfo extends Application {

    private TextField nameField, addressField, provinceField, cityField, postalCodeField, phoneField, emailField;
    private RadioButton csRadioButton, businessRadioButton;
    private ComboBox<String> courseComboBox;
    private ListView<String> courseListView;
    private CheckBox studentCouncilCheckBox, volunteerWorkCheckBox;
    private TextArea displayArea;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Information");

        //gridPane for input fields
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(50);
        gridPane.setVgap(20);

        //st Information
        nameField = addTextField(gridPane, "Name:", 0);
        addressField = addTextField(gridPane, "Address:", 1);
        provinceField = addTextField(gridPane, "Province:", 2);
        cityField = addTextField(gridPane, "City:", 3);
        postalCodeField = addTextField(gridPane, "Postal Code:", 4);
        phoneField = addTextField(gridPane, "Phone Number:", 5);
        emailField = addTextField(gridPane, "Email:", 6);

        //Radio button for streams
        csRadioButton = new RadioButton("Computer Science");
        businessRadioButton = new RadioButton("Business");
        ToggleGroup majorGroup = new ToggleGroup();
        csRadioButton.setToggleGroup(majorGroup);
        businessRadioButton.setToggleGroup(majorGroup);

        HBox majorBox = new HBox(10, csRadioButton, businessRadioButton);
        gridPane.add(new Label("Major:"), 0, 7);
        gridPane.add(majorBox, 1, 7);

        //for courses
        courseComboBox = new ComboBox<>();
        courseListView = new ListView<>();

        csRadioButton.setOnAction(e -> setCourses("Computer Science"));
        businessRadioButton.setOnAction(e -> setCourses("Business"));

        courseComboBox.setOnAction(e -> addCourse());

        gridPane.add(new Label("Courses:"), 0, 8);
        gridPane.add(courseComboBox, 1, 8);
        gridPane.add(courseListView, 1, 9);

        //checkBoxes for activity
        studentCouncilCheckBox = new CheckBox("Student Council");
        volunteerWorkCheckBox = new CheckBox("Volunteer Work");

        HBox activitiesBox = new HBox(10, studentCouncilCheckBox, volunteerWorkCheckBox);
        gridPane.add(new Label("Activities:"), 0, 10);
        gridPane.add(activitiesBox, 1, 10);

        //display info
        displayArea = new TextArea();
        displayArea.setPrefHeight(100);
        displayArea.setEditable(false);

        //display button
        Button displayButton = new Button("Display");
        displayButton.setOnAction(e -> displayInfo());
        gridPane.add(displayButton, 1, 11);

        //layout
        BorderPane layout = new BorderPane();
        layout.setCenter(gridPane);
        layout.setBottom(displayArea);

        Scene scene = new Scene(layout, 500, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TextField addTextField(GridPane pane, String labelText, int row) {
        Label label = new Label(labelText);
        TextField textField = new TextField();
        pane.add(label, 0, row);
        pane.add(textField, 1, row);
        return textField;
    }

    private void setCourses(String major) {
        courseComboBox.getItems().clear();
        if ("Computer Science".equals(major)) {
            courseComboBox.getItems().addAll("Java", "Python", "C#");
        } else if ("Business".equals(major)) {
            courseComboBox.getItems().addAll("Marketing", "Finance", "Accounting");
        }
    }

    private void addCourse() {
        String selectedCourse = courseComboBox.getValue();
        if (selectedCourse != null && !courseListView.getItems().contains(selectedCourse)) {
            courseListView.getItems().add(selectedCourse);
        }
    }

    private void displayInfo() {
        StringBuilder info = new StringBuilder();
        info.append(nameField.getText()).append(", ")
                .append(addressField.getText()).append(", ")
                .append(cityField.getText()).append(", ")
                .append(provinceField.getText()).append(", ")
                .append(postalCodeField.getText()).append(", ")
                .append(phoneField.getText()).append(", ")
                .append(emailField.getText()).append("\n");

        info.append("Courses:\n");
        for (String course : courseListView.getItems()) {
            info.append(course).append("\n");
        }

        if (studentCouncilCheckBox.isSelected()) {
            info.append("Student Council\n");
        }
        if (volunteerWorkCheckBox.isSelected()) {
            info.append("Volunteer Work\n");
        }

        displayArea.setText(info.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
