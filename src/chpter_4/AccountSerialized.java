/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_4;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author WH1108
 */
public class AccountSerialized extends JFrame implements ActionListener{
    JButton read,write;
    //List<String> animals = new ArrayList<>();
    ArrayList<Account> accounts = new ArrayList<>();
    public AccountSerialized() {
        read = new JButton("Read");
        read.addActionListener(this);
        read.setActionCommand("read");
        add(read);
        write = new JButton("Write");
        write.setActionCommand("write");
        write.addActionListener(this);
        add(write);
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }
    public static void main(String[] args) {
        AccountSerialized gui = new AccountSerialized();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(300,130);
        gui.setVisible(true);
        gui.setLocationRelativeTo(null);
        gui.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand()=="write") {
            try{
            String number = JOptionPane.showInputDialog(null, "Enter Number of objects you want to write", "Number navigator",JOptionPane.INFORMATION_MESSAGE);
            int no = Integer.parseInt(number);
            for (int i = 0; i < no; i++) {
                
                Account account = new Account();
                String title = "Enter information of "+(i+1)+" account";
                JOptionPane.showMessageDialog(null, title,"Information Pane ",JOptionPane.WARNING_MESSAGE);
                account.setAccountName(
                        JOptionPane.showInputDialog(null, "Enter Name of this account",
                        "Name",JOptionPane.INFORMATION_MESSAGE));
                account.setAccountNo(Integer.parseInt(
                        JOptionPane.showInputDialog(null, "Enter Number of this account",
                        "Number",JOptionPane.INFORMATION_MESSAGE)));
                account.setAccountBalance(Float.parseFloat(
                        JOptionPane.showInputDialog(null, "Enter Balance of this account",
                        "Balance",JOptionPane.INFORMATION_MESSAGE)));
                
                accounts.add(account);
                
            }
            }catch(Exception e){
                    System.out.println("Exception occur");
                }
            
            try {
                ObjectOutputStream os= new ObjectOutputStream(new FileOutputStream("./src/chpter_4/account.ser"));
                for(Account student: accounts)
                    os.writeObject(student);
                os.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        }else if(ae.getActionCommand()=="read"){
            String result = "";
            try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/chpter_4/account.ser"));
            while(true)
                try{
                   Account account = (Account)ois.readObject();
                    result += "Account Name : "+account.getAccountName() + "\n" +
                            "Account Balance : "+account.getAccountBalance()+ "\n" +
                            "Account Number : "+account.getAccountNo()+"\n\n";
                }catch(ClassNotFoundException | EOFException ex){
                    break;
                }
            ois.close();
            }catch(Exception e){
                System.out.println("Exception occur");
            }
            JOptionPane.showMessageDialog(this, result, "Reuslt Of Read", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
