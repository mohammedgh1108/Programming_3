/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_4;

import java.applet.Applet;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author WH1108
 */
public class UserApp extends Application {
    Label pabelName,labelPassword;
    TextField textName,textPassword;
    Button ok,exit,addStudent,other;
    String userName,password;
    Stage primaryStage;
    Scene secondScene;
    String[] parts,names,passwords;
    
    public void start(Stage primaryStage) throws Exception{
        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(20, 10, 5, 8));
        flowPane.setVgap(10);
        flowPane.setHgap(5);
        flowPane.setPrefWrapLength(170);
        
        FlowPane _flowPane = new FlowPane();
        _flowPane.setPadding(new Insets(20, 20, 5, 20));
        _flowPane.setVgap(20);
        _flowPane.setHgap(120);
        //_flowPane.setPrefWrapLength(170);
        
        File file = new File("./src/chpter_4/loginFile.txt");
        Scanner in = new Scanner(file);
        String info = "";
        while(in.hasNextLine()){
            info+=in.nextLine();
        }
        parts = info.split(" ");
        for (int i = 0; i < parts.length; i++) {
            if (stringContainsNumber(parts[i])) {
                password+=parts[i]+" ";
            }else{
                userName+=parts[i]+" ";
            }
        }
        password = password.substring(4,password.length());
        passwords=password.split(" ");
        userName = userName.substring(4,userName.length());
        names=userName.split(" ");
        pabelName = new Label("Login Name : ");
        labelPassword = new Label("Password :     ");
        textName = new TextField();
        textPassword = new TextField();
        ok = new Button("Ok");
        
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    for (int i = 0; i < names.length; i++) {
                        if (textName.getText().equalsIgnoreCase(names[i])&& md5(textPassword.getText()).equalsIgnoreCase(passwords[i])) {
                            System.out.println("success");
                    primaryStage.setScene(secondScene);
                    primaryStage.show();
                        }
                    }
                    
                
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UserApp.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
        exit = new Button("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               System.exit(0);
            }
        });
        addStudent = new Button("Add Student");
        other = new Button("...");
        addStudent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name,password;
                FileWriter fileWriter = null;
                try {
                    name = JOptionPane.showInputDialog(null, "Enter Student Name : ", "Add New Student", JOptionPane.INFORMATION_MESSAGE);
                    password = md5(JOptionPane.showInputDialog(null, "Enter Student Password : ", "Add New Student", JOptionPane.INFORMATION_MESSAGE));
                    File file = new File("./src/chpter_4/loginFile.txt");
                    if (!file.exists()) {
                        try {
                            file.createNewFile();
                        } catch (IOException ex) {
                            Logger.getLogger(UserApp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    fileWriter = new FileWriter(file,true);
                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    printWriter.write(" "+name+" ");
                    printWriter.write(password);
                    printWriter.close();
                    fileWriter.close();
                } catch (Exception ex) {
                    System.out.println("Exception Occur");
                }
                    }
        });
        flowPane.getChildren().addAll(pabelName,textName,labelPassword,textPassword,ok,exit);
        _flowPane.getChildren().addAll(addStudent,other);
        Scene firstScene = new Scene(flowPane,250,125);
        secondScene = new Scene(_flowPane,250,125);
        primaryStage.setScene(firstScene);
        //ok.setOnAction(e -> primaryStage.setScene(secondScene));
        primaryStage.show();
        
    }
    
    public static String md5(String password) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException{
        launch(args);    
    }
    public static boolean stringContainsNumber( String s )
{
    Pattern p = Pattern.compile( "[0-9]" );
    Matcher m = p.matcher( s );

    return m.find();
}
}
