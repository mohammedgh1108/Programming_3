/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_3_part_1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author mohammed m. ghunaim
 */
public class Third_GUI extends JFrame{
    private JPanel containerOfButtons,containerOfCheckBoxes,containerOfRadio,firstContainer,lastContainer,thirdContainer;
    private JButton ok , cancel,setup,help;
    private JCheckBox image,text,code,print;
    private JRadioButton select,all,applet;
    private JTextArea firstTextArea,secondTextArea,thirdTextArea;
    private JLabel printer,qality; 
    private JComboBox<String> comboBox;
    public Third_GUI(String title){
        super(title);
        JComboBox<String> box = new JComboBox<String>();
        containerOfButtons = new JPanel(new GridLayout(4 , 1, 0, 2));
        containerOfCheckBoxes = new JPanel(new GridLayout(3 , 1, 0, 0));
        containerOfRadio = new JPanel(new GridLayout(3 , 1, 0, 0));
        firstContainer = new JPanel(new FlowLayout());
        lastContainer = new JPanel(new BorderLayout());
        thirdContainer = new JPanel(new FlowLayout());
        ok = new JButton("OK");
        ok.setSize(50,50);
        cancel = new JButton("Cancel");
        setup = new JButton("Setup..");
        help = new JButton("Help");
        containerOfButtons.add(ok);containerOfButtons.add(cancel);
        containerOfButtons.add(setup);containerOfButtons.add(help);
        printer = new JLabel("Printer: MyPrinter");
        qality = new JLabel("Print Quality: ");
        select = new JRadioButton("Select");
        all = new JRadioButton("All");
        applet = new JRadioButton("Applet");
        containerOfRadio.add(select);containerOfRadio.add(all);containerOfRadio.add(applet);
        firstTextArea = new JTextArea(4, 5);
        secondTextArea = new JTextArea(4, 5);
        thirdTextArea = new JTextArea(4, 5);
        image = new JCheckBox("Image");
        text = new JCheckBox("Text");
        code = new JCheckBox("Code");
        print = new JCheckBox("Print to File");
        comboBox = new JComboBox<>();
        comboBox.addItem("High");
        comboBox.addItem("Middle");
        comboBox.addItem("Low");
        containerOfCheckBoxes.add(image);containerOfCheckBoxes.add(text);containerOfCheckBoxes.add(code);
        firstContainer.add(firstTextArea);firstContainer.add(containerOfCheckBoxes);
        firstContainer.add(secondTextArea);firstContainer.add(containerOfRadio);
        firstContainer.add(thirdTextArea);
        //lastContainer.add(qality);lastContainer.add(comboBox);lastContainer.add(print);
        thirdContainer.add(qality);thirdContainer.add(comboBox);thirdContainer.add(print);
        lastContainer.add(printer,BorderLayout.NORTH);
        lastContainer.add(firstContainer,BorderLayout.CENTER);
        lastContainer.add(thirdContainer,BorderLayout.SOUTH);
        //add(printer,BorderLayout.NORTH);
        //add(printer,BorderLayout.NORTH);
        //add(firstContainer,BorderLayout.CENTER);
        /*add(firstTextArea);
        add(containerOfCheckBoxes);
        add(secondTextArea);
        add(containerOfRadio);
        add(thirdTextArea);*/
        add(lastContainer);
        add(containerOfButtons,BorderLayout.EAST);        
    }
    public static void main(String[] args) {
        Third_GUI frame = new Third_GUI("Printer");
        frame.setSize(500, 170);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
    }
}
