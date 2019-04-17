/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author WH1108
 */
public class FileProcessing extends JFrame implements ActionListener{
    private JMenuBar mainMenu;
    private JMenu file,edit;
    private JMenuItem open,close,exit,save,font,color;
    private JTextArea textArea ;
    private JScrollPane scroll;
    private JFileChooser fileChooser;
    
    public FileProcessing(String string) throws HeadlessException {
        super(string);
        mainMenu = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        
        open = new JMenuItem("Open");
        open.setMnemonic(KeyEvent.VK_O);
        open.addActionListener(this);
        
        close= new JMenuItem("Close");
        close.setMnemonic(KeyEvent.VK_C);
        close.addActionListener(this);
        
        save = new JMenuItem("Save");
        save.setMnemonic(KeyEvent.VK_S);
        save.addActionListener(this);
        
        exit = new JMenuItem("Exit");
        exit.setMnemonic(KeyEvent.VK_X);
        exit.addActionListener(this);
        
        font = new JMenuItem("Font");
        font.setMnemonic(KeyEvent.VK_F);
        font.addActionListener(this);
        
        color = new JMenuItem("Color");
        color.setMnemonic(KeyEvent.VK_L);
        color.addActionListener(this);
        
        file.add(open);file.add(save);file.add(close);file.add(exit);
        edit.add(font);edit.add(color);
        mainMenu.add(file);mainMenu.add(edit);
        setJMenuBar(mainMenu);
        
        textArea = new JTextArea("");
        textArea.setLineWrap(true);
        add(textArea);
        scroll = new JScrollPane(textArea);
        scroll.setPreferredSize(new Dimension(292,144));
        add(scroll);
        
        fileChooser = new JFileChooser();

    }
    
    public static void main(String[] args) {
        FileProcessing gui = new FileProcessing("File Processing");
        gui.setSize(300,200);
        gui.setLayout(new FlowLayout(FlowLayout.CENTER));
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setLocationRelativeTo(null);
        gui.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand()=="Open") {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(FileProcessing.this);
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
        }else if (ae.getActionCommand()=="Save") {
            File file = new File("d:/javaFolder/fileChooser.txt");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(FileProcessing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setSelectedFile(file);
//            fileChooser.showSaveDialog(fileChooser);
            try {
                FileWriter fileWriter = new FileWriter(fileChooser.getSelectedFile(), true);
                PrintWriter printWriter = new PrintWriter(fileWriter);
//                printWriter.println(textArea.getText());
                textArea.write(printWriter);
                printWriter.close();
                fileWriter.close();
                JOptionPane.showMessageDialog(null, "File has been saved","File Saved",JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                System.out.println("IOException");
            }
        }else if (ae.getActionCommand()=="Close") {
            textArea.setText("");
            textArea.setEditable(false);
        }else if (ae.getActionCommand()=="Exit") {
            System.exit(0);
        }else if (ae.getActionCommand()=="Font") {
            try{
            Integer selectedSize =(Integer) JOptionPane.showInputDialog(null, "Select new Font Size", "Font Size",
                    JOptionPane.WARNING_MESSAGE,
                    null, 
                    new Integer[]{7,10,13,16,19,22,25,28}, 16);
            textArea.setFont(new Font(null, 0,selectedSize ));
            }catch(NullPointerException ex){
                System.out.println("Null Pointer Exception");
            };
        }else if (ae.getActionCommand()=="Color") {
            Color color = JColorChooser.showDialog(null, "Pick your color", Color.yellow);
            textArea.setForeground(color);
        }
    }
}
