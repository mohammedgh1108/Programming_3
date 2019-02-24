/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author WH1108
 */
public class main {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        //Create an array of 10 Employee objects
        Employee employees[]=new Employee[2];
        
        //objects read by JOptionPane
        for(int i=0; i<employees.length; i++){
        Employee e = new Employee();
        e.setName(JOptionPane.
        showInputDialog(null, "Enter Employee name",
        "Employee " + i, JOptionPane.INFORMATION_MESSAGE));
        e.setDepartment(JOptionPane.
        showInputDialog(null, "Enter Employee department",
        "Employee " + i, JOptionPane.INFORMATION_MESSAGE));
        e.setSalary(Double.parseDouble(JOptionPane.
        showInputDialog(null, "Enter Employee salary",
        "Employee " + i, JOptionPane.INFORMATION_MESSAGE)));
        employees[i] = e;
        }
        
        //objects read by Scanner
        for (int i = 0; i <employees.length; i++) {
            Employee e = new Employee();
            System.out.println("Employee "+i);
            System.out.println("Enter Employee name");
            e.setName(in.next());
            System.out.println("Enter Employee department");
            e.setDepartment(in.next());
            System.out.println("Enter Employee salary");
            e.setSalary(in.nextDouble());
            employees[i]=e;
        }
        
        //sort objects by name
        Arrays.sort(employees);
        
        //sort objects by salary
        for (int i = 0; i < employees.length; i++) {
            for (int j = i+1; j < employees.length; j++) {
                if (employees[j].getSalary()>employees[i].getSalary()) {
                    Employee temp = employees[i];
                    employees[i]=employees[j];
                    employees[j]=temp;
                }
            }
        }
        
        //Show the sorted Employee data using Command Line
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Employee Name : "+employees[i].getName()+"\nEmployee Department : "+employees[i].getDepartment()+"\nEmployee Salary : "+employees[i].getSalary()+"\n");
        }
        //Show the sorted Employee data using JOptionPane
        for( int i = 0;i < employees.length; i++){
            JOptionPane.showMessageDialog(null, employees[i], "Printing results",JOptionPane.INFORMATION_MESSAGE);
        }
        //Access the number of objects by the count member.
        System.out.println(Employee.count);
    }
}
