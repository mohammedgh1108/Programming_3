/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_3_part_2;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author WH1108
 */
public class TemperatureConversion extends JFrame implements ActionListener{
    private JLabel enter , output;
    private JTextField input ; 
    private JRadioButton fah , kel;
    private ButtonGroup radoiGroup;
    private String result="";
    public TemperatureConversion(String string) throws HeadlessException {
        super(string);
        enter = new JLabel("Enter Celsius temperature:");
        input = new JTextField("",20);
        fah = new JRadioButton("Fehrenheit");
        fah.setActionCommand("Fehrenheit");
        fah.addActionListener(this);
        kel = new JRadioButton("Kelvin");
        kel.setActionCommand("Kelvin");
        kel.addActionListener(this);
        output = new JLabel("New Temperature in is :"+result);
        
        radoiGroup = new ButtonGroup();
        radoiGroup.add(fah);radoiGroup.add(kel);
        add(enter);add(input);add(fah);add(kel);add(output);
    }
    
    public static void main(String[] args) {
        TemperatureConversion gui = new TemperatureConversion("Temperature Conversion");
        gui.setLayout(new FlowLayout(FlowLayout.CENTER));
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setLocationRelativeTo(null);
        gui.setResizable(false);
        gui.setSize(265,150);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        double convert =0.0;
        try{
        if (ae.getActionCommand()=="Kelvin") {
            int kelvin = Integer.parseInt(input.getText());
            convert = kelvin + 273.15;
            result = Double.toString(convert);
            output.setText("New Temperature in is :"+result);
        }else{
            int fehrenheit = Integer.parseInt(input.getText());
            convert = fehrenheit * 9/5 + 32;
            result = Double.toString(convert);
            output.setText("New Temperature in is :"+result);
        }}catch(NumberFormatException ex){System.out.println("Number Format Exception");};
    }
}
