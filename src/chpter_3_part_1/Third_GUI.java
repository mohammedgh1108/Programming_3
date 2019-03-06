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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author WH1108
 */
public class Third_GUI extends JFrame{
    private JPanel containerOfButtons,containerOfCheckBoxes,containerOfRadio;
    private JButton ok , cancel,setup,help;
    private JCheckBox image,text,code,print;
    private JRadioButton select,all,applet;
    private JTextArea firstTextArea,secondTextArea;
    private JLabel printer,qality; 
    
    public Third_GUI(String title){
        super(title);
        containerOfButtons = new JPanel(new GridLayout(4 , 1, 0, 2));
        containerOfCheckBoxes = new JPanel(new GridLayout(3 , 1, 0, 0));
        containerOfRadio = new JPanel(new GridLayout(3 , 1, 0, 0));
        ok = new JButton("OK");
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
        secondTextArea =new JTextArea(4, 5);
        image = new JCheckBox("Image");
        text = new JCheckBox("Text");
        code = new JCheckBox("Code");
        print = new JCheckBox("Print");
        containerOfCheckBoxes.add(image);containerOfCheckBoxes.add(text);containerOfCheckBoxes.add(code);
        add(printer,BorderLayout.NORTH);
        add(firstTextArea);
        add(containerOfCheckBoxes);
        add(secondTextArea);
        add(containerOfRadio);
        add(containerOfButtons);
        
    }
    public static void main(String[] args) {
        Third_GUI frame = new Third_GUI("Printer");
        frame.setSize(400, 180);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
    }
}
