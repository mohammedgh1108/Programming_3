/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_5;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author WH1108
 */
public class SecondOne {
    public static void main(String[] args) {
        
            ArrayList<Account_> arrayOfObjects = new ArrayList<Account_>();
        String result = "";
            try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/chpter_5/account_file.ser"));
            while(true)
                try{
                    arrayOfObjects.add((Account_)ois.readObject());                    
                }catch(ClassNotFoundException | EOFException ex){
                    break;
                }
            ois.close();
            }catch(IOException e){
                System.out.println("Exception occur");
            }
            
            Collections.sort(arrayOfObjects, new Comparator<Account_>() {
            @Override
            public int compare(Account_ t, Account_ t1) {
                return (int)(t1.getAccountBalance()-t.getAccountBalance());
            }
        });
        System.out.println("Account Objects Sorted In Descending Format Based On Account Balance\n");
        System.out.printf("%-15s %-20s %10s","Account Name","Account Balance","Account Number"); 
        System.out.println("\n");
        for (int i = 0; i < arrayOfObjects.size(); i++) {
            System.out.printf("%-17s %-20f %5d",arrayOfObjects.get(i).getAccountName(),
                    arrayOfObjects.get(i).getAccountBalance(),arrayOfObjects.get(i).getAccountNo());
            System.out.println("\n");
        }
        System.out.println(result);
            
    }
}
