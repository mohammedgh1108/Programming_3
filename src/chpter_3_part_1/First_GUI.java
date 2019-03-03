/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_3_part_1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author WH1108
 */
public class First_GUI extends JFrame{
    //declare attributes for our gui programe.
    private JPanel containerOfCheckBoxes ,containerOfCheckButtons,containerOfCheckText;
    private JCheckBox snaptogrid ,showgrid ; 
    private JLabel x ,y; 
    private JTextField ofx ,ofy ; 
    private JButton ok ,cancel,help;
    
    public First_GUI(String title){
        super(title);
        setLayout(new FlowLayout());
        //initialize  for each panel we declare and put the layout grid.
        containerOfCheckBoxes = new JPanel(new GridLayout(2, 1, 0, 0));
        containerOfCheckButtons = new JPanel(new GridLayout(3, 1, 0, 10));
        containerOfCheckText = new JPanel(new GridLayout(2, 2, 0, 0));
        //initialize check boxes and give caption to each one.
        snaptogrid = new JCheckBox("Snap to Grid");
        showgrid = new JCheckBox("Show Grid");
        //add the boxes to its container
        containerOfCheckBoxes.add(showgrid);
        containerOfCheckBoxes.add(snaptogrid);
        //initialize values to the label.
        x = new JLabel("X : ");
        y = new JLabel("Y : ");
        ofx = new JTextField("",3);
        ofy = new JTextField("",3);
        //add the labels to its container.
        containerOfCheckText.add(x);containerOfCheckText.add(ofx);
        containerOfCheckText.add(y);containerOfCheckText.add(ofy);
        //give each button i creat its value.
        ok = new JButton("OK");
        cancel = new JButton("Cancel");
        help = new JButton("Help");
        //add the buttons to its container.
        containerOfCheckButtons.add(ok);
        containerOfCheckButtons.add(cancel);
        containerOfCheckButtons.add(help);
        //add the three containeres to the main frame.
        add(containerOfCheckBoxes);
        add(containerOfCheckText);
        add(containerOfCheckButtons);
    }
    public static void main(String[] args) {
        First_GUI gui = new First_GUI("Align");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(300,150);
        gui.setVisible(true);
        gui.setLocationRelativeTo(null);
        gui.setResizable(false);
    }
}
