/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_3_part_1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author WH1108
 */
public class Fourth_GUI extends JFrame{
    
    private JList<String> list;
    private DefaultListModel listelements;
    private JScrollPane scrollOfList;
    private JButton copy ;
    private JTextArea newArea ; 
    
    public Fourth_GUI(String string){
        super(string);
        
        listelements = new DefaultListModel();
        list = new JList<>(listelements);
        list.setSelectionMode(1);
        listelements.addElement("Black");
        listelements.addElement("Blue");
        listelements.addElement("Cyan");
        listelements.addElement("Dark Gray");
        listelements.addElement("Gray");
        listelements.addElement("Red");
        listelements.addElement("Scarlet");
        listelements.addElement("Dark Red");
        add(list);
        scrollOfList = new JScrollPane(list);
        scrollOfList.setPreferredSize(new Dimension(100,100));
        add(scrollOfList);
        
        copy = new JButton("Copy >>>");
        add(copy);
        
        newArea = new JTextArea("Black\nCyan\nGray");
        newArea.setPreferredSize(new Dimension(100,80));
        newArea.setLineWrap(true);
        add(newArea);
        
    }
    
    
    public static void main(String[] args) {
        Fourth_GUI gui = new Fourth_GUI("Multiple Selection Lists");
        gui.setSize(400,145);
        gui.setVisible(true);
        gui.setResizable(false);
        gui.setLayout(new FlowLayout());
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setLocationRelativeTo(null);
    }
}
