/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_3_part_2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author WH1108
 */
public class MultipleSelectionList extends JFrame implements ActionListener{
    private JList<String> list,copyList;
    private DefaultListModel listelements,listcopyelements;
    private JScrollPane scrollOfList,scrollOfCopyList;
    private JButton copyButton ;
    private JTextArea newArea ;
    
    public MultipleSelectionList(String string) throws HeadlessException {
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
        
        copyButton = new JButton("Copy >>>");
        copyButton.addActionListener(this);
        add(copyButton);
        
        listcopyelements = new DefaultListModel();
        copyList = new JList<>(listcopyelements);
        //copyList.setPreferredSize(new Dimension(100,100));
        add(copyList);
        scrollOfCopyList = new JScrollPane(copyList);
        scrollOfCopyList.setPreferredSize(new Dimension(100,100));
        add(scrollOfCopyList);
        
    }
    
    public static void main(String[] args) {
        MultipleSelectionList gui = new MultipleSelectionList("Temperature Conversion");
        gui.setSize(400,145);
        gui.setLayout(new FlowLayout(FlowLayout.CENTER));
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setLocationRelativeTo(null);
        gui.setResizable(false);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        List<String> result = list.getSelectedValuesList();
        //List<String> result1 = list.getSelectedValuesList(); 
        //List<String> li = list.getSelectedValuesList();
        if (list.getSelectedValue()==null) {
            JOptionPane.showMessageDialog(null, "No Item Selected ", "Warning", JOptionPane.WARNING_MESSAGE, null);
        }
        for(String s :result){
            listcopyelements.addElement(s);
        }
        //listcopyelements.addElement(list.getSelectedValue());
    }
}
