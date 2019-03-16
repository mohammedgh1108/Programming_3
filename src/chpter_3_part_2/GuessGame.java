/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_3_part_2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *
 * @author WH1108
 */
public class GuessGame extends JFrame implements ActionListener{
    private JTextArea textArea,labelOfButton;
    private JTextField inputField;
    private JButton newGame;
    public int random;
    public GuessGame(String string) throws HeadlessException {
        super(string);
        
        random = getRandomNumberInRange(1,1000);
        
        textArea = new JTextArea("I have a number between 1 and 1000.\n       Can you guess my number?");
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setFont(new Font(string, Font.BOLD,13));
        add(textArea);
        labelOfButton = new JTextArea("Please enter your first guess : ");
        labelOfButton.setOpaque(false);
        labelOfButton.setEditable(false);
        labelOfButton.setFont(new Font(string, Font.BOLD,13));
        add(labelOfButton);
        inputField = new JTextField(5);
        inputField.addActionListener(this);
        inputField.setActionCommand("guess");
        add(inputField);
        newGame = new JButton("New Game");
        newGame.addActionListener(this);
        add(newGame);
    }
    
    public static void main(String[] args) {
        GuessGame gui = new GuessGame("Guessing Game");
        gui.setSize(360,145);
        gui.setLayout(new FlowLayout(FlowLayout.CENTER));
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setLocationRelativeTo(null);
        gui.setResizable(false);
        System.out.println("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand()=="guess") {
            try{
                int input = Integer.parseInt(inputField.getText());
                if (input>random) {
                    this.getContentPane().setBackground(Color.red);
                    labelOfButton.setText("Too High. Try a lower number");
                }else if (input<random) {
                    this.getContentPane().setBackground(Color.blue);
                    labelOfButton.setText("Too Low. Try a higher number");
                }else{
                    this.getContentPane().setBackground(Color.green);
                    labelOfButton.setText("                            Correct!   ");
                }
            }catch(Exception ex){
                System.out.println("Null Pointer Exception OR Number Format Exception");
            }
        }else{
            inputField.setText("");
            random =getRandomNumberInRange(1,1000);
            this.getContentPane().setBackground(null );
        }
    }
    
    
    
    
    private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
