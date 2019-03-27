/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_3_part_3;




import com.sun.webkit.ColorChooser;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.Mnemonic;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author WH1108
 */
public class FileView extends Application implements EventHandler<Event>{

    private MenuBar mainMenu;
    private Menu file, edit;
    private MenuItem open, close, exit, font, color;
    private TextArea textArea ;
    private int[]fontSize = {12,14,16,18,20,22};
    
    private final String [] arrayFontDaialog = {"12","14","16","18","20","22"};
    private List<String> listFontDaialog;
    
    private final String [] arrayColorDaialog = {"Red","Cyan","Gray","Green","Blue"};
    private List<String> listColorDaialog;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane flowPane = new FlowPane();
        
        open = new MenuItem("Open");
        open.addEventHandler(EventType.ROOT, this);
        open.setAccelerator(
            KeyCombination.keyCombination("SHORTCUT+O")
        );
        
        close = new MenuItem("Close");
        close.addEventHandler(EventType.ROOT, this);
        close.setAccelerator(
            KeyCombination.keyCombination("SHORTCUT+C")
        );
        
        exit = new MenuItem("Exit");
        exit.addEventHandler(EventType.ROOT, this);
        exit.setAccelerator(
            KeyCombination.keyCombination("SHORTCUT+X")
        );
        
        font = new MenuItem("Font");
        font.addEventHandler(EventType.ROOT, this);
        font.setAccelerator(
            KeyCombination.keyCombination("SHORTCUT+F")
        );
        
        color = new MenuItem("Color");
        color.addEventHandler(EventType.ROOT, this);
        color.setAccelerator(
            KeyCombination.keyCombination("SHORTCUT+l")
        );
        
        file = new Menu("File", null, open, close, exit);
        file.setMnemonicParsing(true);
        open.setAccelerator(
            KeyCombination.keyCombination("SHORTCUT+O")
        );

        edit = new Menu("Edit",null,font,color);
        
        mainMenu = new MenuBar(file, edit);
        
        textArea = new TextArea();
        textArea.setMinSize(250, 250);
        textArea.setMaxSize(250, 250);
        
        textArea.setWrapText(true);
        flowPane.getChildren().setAll(mainMenu,textArea);
        Scene scene = new Scene(flowPane,250,275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(Event event) {
        if (event.getSource()==open) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            File selectedFile = fileChooser.getSelectedFile();
            
            try {
                Scanner scanner = new Scanner(selectedFile);
                String result = "";
                while(scanner.hasNextLine()){
                    result+=scanner.nextLine();
                }                
                textArea.setText(result);
                textArea.setEditable(true);
            } catch (Exception ex) {
                System.out.println("Exception occur");
            }
        }else if (event.getSource()==exit) {
            System.exit(0);
        }else if (event.getSource()==close) {
            textArea.setText("");
            textArea.setEditable(false);
        }else if (event.getSource()==font) {
            try{
                listFontDaialog = Arrays.asList(arrayFontDaialog);
                ChoiceDialog fontDialog = new ChoiceDialog(listFontDaialog.get(3),listFontDaialog);
                fontDialog.setTitle("Font Size Chooser");
                fontDialog.setHeaderText("Select your Size");
                Optional result = fontDialog.showAndWait();
                int size = Integer.parseInt(String.valueOf(result.get()));
                textArea.setFont(new Font(size));
                /*Integer result = (Integer)JOptionPane.showInputDialog(null, "Select Font Size : ", "Font Size", JOptionPane.WARNING_MESSAGE
                , null,new Integer[]{10,14,16,18,20,22,24}, 18);
                textArea.setFont(new Font(result));*/
            }catch(Exception ex){
                System.out.println("Exception occur");
            }
        }else if (event.getSource()==color) {
           try{
               listColorDaialog = Arrays.asList(arrayColorDaialog);
               ChoiceDialog colorDialog = new ChoiceDialog(listColorDaialog.get(0),listColorDaialog);
               colorDialog.setTitle("Font Color Chooser");
               colorDialog.setHeaderText("Select your Color");
               Optional result = colorDialog.showAndWait();
               String stringOfColor = String.valueOf(result.get());
               System.out.println(stringOfColor);
               Color color = Color.BLACK;
               if (stringOfColor=="Red") {
                   textArea.setStyle("-fx-text-inner-color: red;");
               }else if (stringOfColor=="Cyan") {
                   textArea.setStyle("-fx-text-inner-color: Cyan;");
               }else if (stringOfColor=="Gray") {
                   textArea.setStyle("-fx-text-inner-color: gray;");
               }else if (stringOfColor=="Green") {
                   textArea.setStyle("-fx-text-inner-color: green;");
               }else if (stringOfColor=="Blue") {
                   textArea.setStyle("-fx-text-inner-color: blue;");
               }
            }catch(Exception ex){
                System.out.println("Exception occur");
            } 
        }
    }

}
