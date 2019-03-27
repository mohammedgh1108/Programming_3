/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_3_part_3;


import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author WH1108
 */
public class MutipleSelectionLists extends Application implements EventHandler<Event>{
    ListView colors;
    ListView copyColors ;
    Button copy;
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        FlowPane flowPane = new FlowPane();
        copy = new Button("Copy >>> ");
        colors = new ListView();
        colors.setMaxSize(180, 120);
        colors.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        copy.addEventHandler(MouseEvent.MOUSE_CLICKED,this);
        ObservableList<String> items = FXCollections.observableArrayList(
            "Black","White","Green","Cyan","Gray","Dark Gray");
        colors.setItems(items);
        
        copyColors = new ListView();
        copyColors.setMaxSize(180, 120);
        
        flowPane.getChildren().setAll(colors,copy,copyColors);
        
        Scene scene = new Scene(flowPane,436,140);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(Event event) {
        try {
            List<String> result = colors.getSelectionModel().getSelectedItems();
            if (colors.getSelectionModel().getSelectedItem() == null) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setContentText("Button with no item selections.");
                alert.showAndWait();
            }
            for (String s : result) {
                copyColors.getItems().add(copyColors.getItems().size(), s);
                //copyColors.setItems(FXCollections.observableArrayList(s));
            }
        } catch (Exception e) {
            System.out.println("Exception occur");
        }
    }
}
