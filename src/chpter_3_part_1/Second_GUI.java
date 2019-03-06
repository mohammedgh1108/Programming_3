/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_3_part_1;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author WH1108
 */
public class Second_GUI extends JFrame{
    //declare attributes for our gui programe.
    private JTextField text ; 
    private JPanel firstcol ,secondcol,thirdcol,fourthcol;
    private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;

    public Second_GUI(String title){
        super(title);
        //set flow layout for the loayout of the main window
        setLayout(new FlowLayout());
        //initialize text with 16 columns width
        text = new JTextField("",16);
        //initialize first column and put the layout to grid with 4 rows , 1 column and 2 vgap
        firstcol = new JPanel(new GridLayout(4, 1, 0, 2));
        //initialize second column and put the layout to grid with 4 rows , 1 column and 2 vgap
        secondcol =  new JPanel(new GridLayout(4, 1, 0, 2));
        //initialize third column and put the layout to grid with 4 rows , 1 column and 2 vgap
        thirdcol =  new JPanel(new GridLayout(4, 1, 0, 2));
        //initialize fourth column and put the layout to grid with 4 rows , 1 column and 2 vgap
        fourthcol =  new JPanel(new GridLayout(4, 1, 0, 2));
        
        ////initialize the 9s buttons and give them its values.
        b1 = new JButton("9");
        b2 = new JButton("8");
        b3 = new JButton("7");
        b4 = new JButton("6");
        b5 = new JButton("5");
        b6 = new JButton("4");
        b7 = new JButton("3");
        b8 = new JButton("2");
        b9 = new JButton("1");
        b10 = new JButton("0");
        b11 = new JButton(".");
        b12 = new JButton("=");
        b13 = new JButton("/");
        b14 = new JButton("*");
        b15 = new JButton("-");
        b16 = new JButton("+");
        
        //add each button to its specific column.
        firstcol.add(b3);firstcol.add(b6);firstcol.add(b9);firstcol.add(b10);
        secondcol.add(b2);secondcol.add(b5);secondcol.add(b8);secondcol.add(b11);
        thirdcol.add(b1);thirdcol.add(b4);thirdcol.add(b7);thirdcol.add(b12);
        fourthcol.add(b13);fourthcol.add(b14);fourthcol.add(b15);fourthcol.add(b16);
        //add the text field to the main window.
        add(text);
        //add the main columns to the main window.
        add(firstcol);add(secondcol);add(thirdcol);add(fourthcol);
        
    }
    
    public static void main(String[] args) {
        Second_GUI gui = new Second_GUI("Calculater");
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setLocationRelativeTo(null);
        gui.setResizable(false);
        gui.setSize(190,172);
    }
}
