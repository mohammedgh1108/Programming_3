/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_4;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author WH1108
 */
public class Transferred extends JFrame implements ActionListener{
    
    JTextField textField;
    JButton setPath,convert,convertToText;
    File file;
    public Transferred() {
        setPath = new JButton("Choose File to convert");
        setPath.setActionCommand("path");
        setPath.addActionListener(this);
        add(setPath);
        textField = new JTextField(25);
        textField.setEditable(false);
        add(textField);
        convert = new JButton("Convert To Binary");
        convert.setActionCommand("convertToBinary");
        convert.addActionListener(this);
        add(convert);
        convertToText = new JButton("Convert To Text File");
        convertToText.addActionListener(this);
        convertToText.setActionCommand("convertToText");
        add(convertToText);
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }
    
    public static void main(String[] args) {
        Transferred gui = new Transferred();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(300,130);
        gui.setVisible(true);
        gui.setLocationRelativeTo(null);
        gui.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand()=="path") {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(this);
            file = fileChooser.getSelectedFile();
            textField.setText(file.getPath());
            String fileName = file.getName();
            int dotIndex = fileName.lastIndexOf('.');
            String extension= (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
            if (extension.equalsIgnoreCase("txt")) {
                convertToText.setEnabled(false);
            }else if(extension.equalsIgnoreCase("dat")){
                convert.setEnabled(false);
            }
            System.out.println(dotIndex);
        }if(ae.getActionCommand()=="convertToBinary"){
            try{
            String result = "";
            try {
                File _file = new File(file.getParent()+"/newBinaryFile.dat");
                if (!_file.exists()) {
                    _file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(_file,true);
                DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
                Scanner scanner = new Scanner(file);
                if (scanner.hasNextLine()) {
                    result+=scanner.nextLine();
                }
                try {
                    dataOutputStream.writeChars(result);
                } catch (IOException ex) {
                    
                }
                dataOutputStream.close();
                fileOutputStream.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Transferred.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Transferred.class.getName()).log(Level.SEVERE, null, ex);
            }
            }catch(Exception e){
                System.out.println("Enter path of the file FIRST!");
            }  
        }else if(ae.getActionCommand()=="convertToText"){
            try{
            String result="";
            try {
                File _file = new File(file.getParent()+"/newTextFile.txt");
                FileInputStream fileInputStream = new FileInputStream(file);
                DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                int i;
                while((i=dataInputStream.read())!=-1){
                    result+=(char)i;
                }
                
                FileWriter fileWriter = new FileWriter(_file,true);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.println(result);
                printWriter.close();
                fileWriter.close();
                System.out.println(result);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Transferred.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Transferred.class.getName()).log(Level.SEVERE, null, ex);
            }
            }catch(Exception e){
                System.out.println("Enter path of the file FIRST!");
            }
        }
    }
}
